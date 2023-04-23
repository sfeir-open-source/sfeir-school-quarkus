package com.sfeir.quarkus100.racer;

import com.sfeir.quarkus100.racer.client.Character;
import com.sfeir.quarkus100.racer.client.CharacterClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RacerService {

    @Inject
    CharacterClient characterClient;

    public Racer random() {
        Character character = randomCharacter();
        return new Racer(character, null);
    }

    @Fallback(fallbackMethod = "fallbackCharacter")
    Character randomCharacter() {
        return characterClient.random();
    }

     Character fallbackCharacter(){
        Log.warn("character fallback");
        return new Character("fallback", 0, 0);
    }
}
