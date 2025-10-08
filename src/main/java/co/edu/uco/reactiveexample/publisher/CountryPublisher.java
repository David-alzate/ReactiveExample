package co.edu.uco.reactiveexample.publisher;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class CountryPublisher {

    private final Sinks.Many<CountryEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public void SendCreatedEvent(CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.CREATED));
    }

    public void SendUpdatedEvent(CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.UPDATED));
    }

    public void SendDeletedEvent(CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.DELETED));
    }

}