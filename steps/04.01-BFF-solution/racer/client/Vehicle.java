package com.sfeir.quarkus100.racer.client;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "The vehicle used for the race")
public record Vehicle(@NotNull String name, int speed, float acceleration) {
}
