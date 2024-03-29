package com.sfeir.quarkus.racer.client;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "The racing character")
public record Character(@NotNull String name, int speed, float acceleration) {
}
