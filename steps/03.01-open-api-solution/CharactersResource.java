package com.sfeir.quarkus100;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import javax.decorator.Delegate;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/characters")
public class CharactersResource {

    private final CharacterService service;

    public CharactersResource(CharacterService service) {
        this.service = service;
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive Quarkus";
    }

    @Operation(summary = "Get a random character")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON,
            schema = @Schema(implementation = Character.class, required = true)))
    @GET
    @Path("/random")
    public RestResponse<Character> random() {
        Character random = service.random();
        return RestResponse.ok(random);
    }

    @Operation(summary = "Get a character by its id")
    @APIResponse(responseCode = "200", description = "When the character is found",
            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Character.class)))
    @APIResponse(responseCode = "204", description = "When the character is not found")
    @GET
    @Path("/{id}")
    public RestResponse<Character> get(@RestPath @Parameter(required = true) Long id) {
        return service.findById(id)
                      .map(RestResponse::ok)
                      .orElse(RestResponse.noContent());
    }

    @Operation(summary = "Creates a character")
    @APIResponse(responseCode = "201", headers = @Header(name = HttpHeaders.LOCATION,
            description = "URI to the created character", schema = @Schema(implementation = URI.class)))
    @POST
    public RestResponse<Void> createCharacter(
            @Valid Character character,
            @Context UriInfo uriInfo) {
        Character created = service.persistCharacter(character);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(created.id));
        return RestResponse.created(builder.build());
    }

    @Operation(summary = "Updates a character")
    @APIResponse(responseCode = "200", description = "The character to update",
            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Character.class)))
    @PUT
    public RestResponse<Character> update(@Valid Character character) {
        Character updated = service.update(character);
        return RestResponse.ok(updated);
    }

    @Operation(summary = "Deletes the character with the given id")
    @APIResponse(responseCode = "204")
    @DELETE
    @Path("/{id}")
    public RestResponse<Void> delete(@RestPath Long id) {
        service.delete(id);
        return RestResponse.noContent();
    }


}