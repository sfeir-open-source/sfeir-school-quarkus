package com.sfeir.quarkus100.racer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/racers")
public class RacerResource {

    private final RacerService service;

    public RacerResource(RacerService service) {
        this.service = service;
    }

    @Path("/random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response random() {
        return Response.ok(service.random()).build();
    }
}