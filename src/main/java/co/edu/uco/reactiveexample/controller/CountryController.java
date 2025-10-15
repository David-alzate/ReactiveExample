package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

    private final CountryService countryService;
    private final CountryRepository countryRepository;
    private final CountryPublisher countryPublisher;

    public CountryController(CountryService countryService, CountryRepository countryRepository, CountryPublisher countryPublisher) {
        this.countryService = countryService;
        this.countryRepository = countryRepository;
        this.countryPublisher = countryPublisher;
    }

    @GetMapping(path = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CountryEvent> publishEvents() {
        return countryPublisher.getStram();
    }

    @GetMapping
    public Flux<CountryEntity> getAllCountries() {
        return countryService.findAll();
    }

    @PostMapping
    public Mono<CountryEntity> saveCountry(@RequestBody CountryEntity countryEntity) {
        return countryService.create(countryEntity);
    }

    @DeleteMapping("/{id}")
    public Mono<CountryEntity> deleteCountryById(@PathVariable int id) {
        return countryService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<CountryEntity> updateCountry(@PathVariable int id,
                                             @RequestBody CountryEntity country) {
        country.setId(id);
        return countryRepository.save(country);
    }

}
