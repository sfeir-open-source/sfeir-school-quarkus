package com.sfeir.quarkus100.racer;

import com.sfeir.quarkus100.racer.client.Character;
import com.sfeir.quarkus100.racer.client.Vehicle;
import io.smallrye.common.constraint.NotNull;

public record Racer(@NotNull Character character, Vehicle vehicle) {

}
