package com.sfeir.quarkus100.racer.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/characters")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
@ApplicationScoped
public interface CharacterAPI {

    @GET
    @Path("/random")
    Character random();
}
