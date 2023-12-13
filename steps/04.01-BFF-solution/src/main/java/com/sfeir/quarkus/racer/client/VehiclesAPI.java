package com.sfeir.quarkus.racer.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "vehicule-api")
@ApplicationScoped
public interface VehiclesAPI {

    @GET
    @Path("/random")
    Vehicle random();
}
