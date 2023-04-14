package com.sfeir.quarkus100;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CharacterService {

    @Transactional(Transactional.TxType.SUPPORTS)
    public Character random(){
        return Character.random();
    }

    public Character persistCharacter(@Valid Character character) {
        character.persist();
        return character;
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
