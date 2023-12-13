package com.sfeir.quarkus.racer.client;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class CharacterClient {

    private final CharacterAPI api;

    public CharacterClient(@RestClient CharacterAPI api) {
        this.api = api;
    }

    @CircuitBreaker(requestVolumeThreshold = 4, delay = 10, delayUnit = ChronoUnit.SECONDS)
    @Retry(maxRetries = 3, delay = 200)
    public Character random() {
        Log.info("Call random character");
        return api.random();
    }
}
