package com.sfeir.quarkus100.racer.client;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class CharacterClient {

    private final CharactersAPI charactersAPI;

    public CharacterClient(@RestClient CharactersAPI charactersAPI) {
        this.charactersAPI = charactersAPI;
    }

    @CircuitBreaker(requestVolumeThreshold = 4,
            delay = 10,
            delayUnit = ChronoUnit.SECONDS)
    @Retry(maxRetries = 3, delay = 200)
    public Character random() {
        Log.info("Call random hero");
        return charactersAPI.random();
    }
}
