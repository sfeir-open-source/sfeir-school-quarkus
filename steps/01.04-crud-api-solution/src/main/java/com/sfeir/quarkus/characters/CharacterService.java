package com.sfeir.quarkus.characters;

import com.sfeir.quarkus.characters.Character;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
@Transactional

public class CharacterService {
  @Transactional(Transactional.TxType.SUPPORTS)
  public Character random(){
    return Character.random();
  }

  public Character persistCharacter(@Valid Character character) {
    character.id = null;
    character.persist();
    return character;
  }

  public Collection<Character> listAll(){
    return Character.listAll();
  }
  public Optional<Character> findById(Long id){
    return Character.findByIdOptional(id);
  }

  public Character update(@Valid Character character) {
    Character toUpdate = Character.findById(character.id);
    toUpdate.name = character.name;
    toUpdate.type = character.type;
    toUpdate.speed = character.speed;
    toUpdate.acceleration = character.acceleration;
    return toUpdate;
  }

  public void delete(Long id){
    var toDelete = Character.findById(id);
    toDelete.delete();
  }
}
