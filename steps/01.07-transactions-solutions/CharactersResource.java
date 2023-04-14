package com.sfeir.quarkus100;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import javax.decorator.Delegate;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/api/characters")
public class CharactersResource {

    private final CharacterService service;

    public CharactersResource(CharacterService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive Quarkus";
    }

    @GET
    @Path("/random")
    public RestResponse<Character> random() {
        Character random = service.random();
        return RestResponse.ok(random);
    }

    @GET
    @Path("/{id}")
    public RestResponse<Character> get(@RestPath Long id) {
        return service.findById(id)
                      .map(RestResponse::ok)
                      .orElse(RestResponse.noContent());
    }

    @POST
    public RestResponse<Void> createCharacter(
            @Valid Character character,
            @Context UriInfo uriInfo) {
        Character created = service.persistCharacter(character);
        URI path = uriInfo.getAbsolutePathBuilder().path(created.id.toString()).build();
        return RestResponse.created(path);
    }

    @PUT
    public RestResponse<Character> update(@Valid Character character){
        Character updated = service.update(character);
        return RestResponse.ok(updated);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> delete(@RestPath Long id){
        service.delete(id);
        return RestResponse.noContent();
    }


}