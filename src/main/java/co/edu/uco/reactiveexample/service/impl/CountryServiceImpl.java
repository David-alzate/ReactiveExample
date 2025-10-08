package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryPublisher countryPublisher;

    public CountryServiceImpl(CountryRepository countryRepository, CountryPublisher countryPublisher) {
        this.countryRepository = countryRepository;
        this.countryPublisher = countryPublisher;
    }

    @Override
    public Mono<CountryEntity> create(CountryEntity countryEntity) {
        return countryRepository.save(countryEntity).then(countryRepository.findByName(countryEntity.getName()))
                .doOnNext(countryPublisher::SendCreatedEvent);
    }

    @Override
    public Mono<CountryEntity> update(int id, CountryEntity countryEntity) {
        return countryRepository.findById(id).flatMap(existingCountry -> {
            existingCountry.setName(countryEntity.getName());
            existingCountry.setDialingCountryCode(countryEntity.getDialingCountryCode());
            existingCountry.setEnabled(countryEntity.isEnabled());
            existingCountry.setIsoCountryCode(countryEntity.getIsoCountryCode());
            return countryRepository.save(existingCountry);
        });
    }

    @Override
    public Mono<CountryEntity> delete(int id) {
        return countryRepository.findById(id).flatMap(existingCountry -> countryRepository.delete(existingCountry)
                .then(Mono.just(existingCountry)));
    }

    @Override
    public Mono<CountryEntity> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Mono<CountryEntity> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return countryRepository.findAll();
    }
}
