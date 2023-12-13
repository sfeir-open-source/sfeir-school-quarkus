package com.sfeir.quarkus;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/karts")
public class KartsResource {

  @Inject
  VehicleRepository repository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<List<Vehicle>> getAllKarts() {
    return repository.findAllVehicle();
  }
}
