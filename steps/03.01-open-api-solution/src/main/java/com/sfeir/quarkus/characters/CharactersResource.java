package com.sfeir.quarkus.characters;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.Collection;

@Path("/api/characters")
public class CharactersResource {
  private final CharacterService service;

  public CharactersResource(CharacterService service) {
    this.service = service;
  }

  @Operation(summary = "Get all characters")
  @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Character.class, type = SchemaType.ARRAY, required = true)))
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<Character> getCharacters() {
    return this.service.listAll();
  }

  @Operation(summary = "Get a random character")
  @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Character.class, required = true)))
  @GET
  @Path("/random")
  public RestResponse<Character> random() {
    Character random = service.random();
    return RestResponse.ok(random);
  }

  @Operation(summary = "Get a character by its id")
  @APIResponse(responseCode = "200", description = "When the character is found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Character.class)))
  @APIResponse(responseCode = "204", description = "When the character is not found")
  @GET
  @Path("/{id}")
  public RestResponse<Character> get(@RestPath @Parameter(required = true) Long id) {
    return service.findById(id)
      .map(RestResponse::ok)
      .orElse(RestResponse.noContent());
  }

  @Operation(summary = "Creates a character")
  @APIResponse(responseCode = "201", headers = @Header(name = HttpHeaders.LOCATION, description = "URI to the created character", schema = @Schema(implementation = URI.class)))
  @POST
  public RestResponse<Void> createCharacter(
    @Valid Character character,
    @Context UriInfo uriInfo) {
    Character created = service.persistCharacter(character);
    URI path = uriInfo.getAbsolutePathBuilder().path(created.id.toString()).build();
    return RestResponse.created(path);
  }

  @Operation(summary = "Updates a character")
  @APIResponse(responseCode = "200", description = "The character to update", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Character.class)))
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
