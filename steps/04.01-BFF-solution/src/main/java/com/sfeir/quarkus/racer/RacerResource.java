package com.sfeir.quarkus.racer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/racers")
public class RacerResource {

  private final RacerService service;

  public RacerResource(RacerService service) {
    this.service = service;
  }

  @GET
  @Path("/random")
  @Produces(MediaType.APPLICATION_JSON)
  public Response random() {
    return Response.ok(service.random()).build();
  }

}
