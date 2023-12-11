package com.sfeir.quarkus.characters;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.List;

@Path("/api/characters")
public class CharactersResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<Character> getCharacters() {
    return Character.listAll();
  }
}
