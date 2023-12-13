package com.sfeir.quarkus.racer;

import com.sfeir.quarkus.racer.client.Character;
import com.sfeir.quarkus.racer.client.CharacterClient;
import com.sfeir.quarkus.racer.client.Vehicle;
import com.sfeir.quarkus.racer.client.VehicleClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.Fallback;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RacerService {

    @Inject
    CharacterClient characterClient;
    @Inject
    VehicleClient vehicleClient;

    public Racer random() {
        Character character = randomCharacter();
        Vehicle vehicle = randomVehicle();
        return new Racer(character, vehicle);
    }

    @Fallback(fallbackMethod = "fallbackVehicle")
    Vehicle randomVehicle() {
        return vehicleClient.random();
    }

    @Fallback(fallbackMethod = "fallbackCharacter")
    Character randomCharacter() {
        return characterClient.random();
    }

    Character fallbackCharacter() {
        Log.warn("character fallback");
        return new Character("fallback", 0, 0);
    }

    Vehicle fallbackVehicle() {
        Log.warn("vehicle fallback");
        return new Vehicle("fallback", 0, 0);
    }
}
