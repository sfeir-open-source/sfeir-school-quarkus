package com.sfeir.quarkus100.racer.client;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class VehicleClient {

    private final VehiclesAPI api;

    public VehicleClient(@RestClient VehiclesAPI api) {
        this.api = api;
    }

    @CircuitBreaker(requestVolumeThreshold = 4,
            delay = 10,
            delayUnit = ChronoUnit.SECONDS)
    @Retry(maxRetries = 3, delay = 200)
    public Vehicle random() {
        Log.info("Call random vehicle");
        return api.random();
    }
}
