package com.notifyLogist.demoApp1.service.imp;

import com.notifyLogist.demoApp1.entity.PersonaEntity;
import com.notifyLogist.demoApp1.repository.PersonaRepository;
import com.notifyLogist.demoApp1.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImp implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<PersonaEntity> getAll() {
        return this.personaRepository.findAll();
    }

    @Override
    public PersonaEntity findById(Integer idPersona) {
        PersonaEntity personaEntity = this.personaRepository.getById(idPersona);
        return personaEntity;
    }

    @Override
    public void create(PersonaEntity personaEntity) {
        this.personaRepository.save(personaEntity);
    }

    @Override
    public void update(PersonaEntity personaEntity) {
        this.personaRepository.save(personaEntity);
    }

    @Override
    public void delete(PersonaEntity personaEntity) {
        this.personaRepository.delete(personaEntity);
    }
}
