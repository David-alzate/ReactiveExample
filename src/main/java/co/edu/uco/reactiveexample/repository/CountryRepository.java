package co.edu.uco.reactiveexample.repository;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<CountryEntity, Integer> {

    Mono<CountryEntity> findByName(String name);
}
