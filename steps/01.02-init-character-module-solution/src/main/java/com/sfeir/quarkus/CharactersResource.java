package com.sfeir.quarkus;

import com.sfeir.quarkus.core.Character;
import jakarta.ws.rs.GET;
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
        return List.of(new Character("Luigi"));
    }
}
