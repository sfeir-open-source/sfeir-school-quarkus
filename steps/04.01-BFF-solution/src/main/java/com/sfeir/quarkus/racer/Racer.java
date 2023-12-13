package com.sfeir.quarkus.racer;

import com.sfeir.quarkus.racer.client.Character;
import com.sfeir.quarkus.racer.client.Vehicle;
import io.smallrye.common.constraint.NotNull;

public record Racer(@NotNull Character character, Vehicle vehicle) {

}
