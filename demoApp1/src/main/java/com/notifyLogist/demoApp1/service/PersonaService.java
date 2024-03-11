package com.notifyLogist.demoApp1.service;

import com.notifyLogist.demoApp1.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    List<PersonaEntity> getAll();

    PersonaEntity findById(Integer idPersona);

    void create(PersonaEntity personaEntity);
    void update(PersonaEntity personaEntity);
    void delete(PersonaEntity personaEntity);
}
