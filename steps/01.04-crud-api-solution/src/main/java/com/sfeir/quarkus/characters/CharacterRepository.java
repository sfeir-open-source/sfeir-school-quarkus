package com.sfeir.quarkus.characters;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CharacterRepository implements PanacheRepository<Character> {

}
