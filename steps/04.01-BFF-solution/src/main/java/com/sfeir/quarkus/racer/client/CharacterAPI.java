package com.sfeir.quarkus.racer.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/characters")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "character-api")
@ApplicationScoped
public interface CharacterAPI {

    @GET
    @Path("/random")
    Character random();
}
