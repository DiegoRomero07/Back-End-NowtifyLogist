package com.notifyLogist.demoApp1.business;

import com.notifyLogist.demoApp1.dtos.PersonaDto;
import com.notifyLogist.demoApp1.entity.PersonaEntity;
import com.notifyLogist.demoApp1.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaBusiness {

    @Autowired
    private PersonaService personaService;

    private List<PersonaEntity> personaEntityList;

    private final List<PersonaDto> personaDtoList = new ArrayList<>();

    public List<PersonaDto> getAll(){
        this.personaEntityList = this.personaService.getAll();
        this.personaEntityList.stream().forEach(personaEntity -> {
            PersonaDto personaDto = new PersonaDto();
            personaDto.setIdPersona(personaEntity.getIdPersona());
            personaDto.setNombres(personaEntity.getNombres());
            personaDto.setApellidos(personaEntity.getApellidos());
            personaDto.setEmail(personaEntity.getEmail());
            personaDto.setTelefono(personaEntity.getTelefono());

            personaDtoList.add(personaDto);
        });
        return personaDtoList;
    }
    public PersonaEntity findById(Integer idPersona){
        return this.personaService.findById(idPersona);
    }

    public void createPersona(PersonaDto personaDto) throws Exception{
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setNombres(personaDto.getNombres());
        personaEntity.setApellidos(personaDto.getApellidos());
        personaEntity.setEmail(personaDto.getEmail());
        personaEntity.setTelefono(personaDto.getTelefono());

        this.personaService.create(personaEntity);
    }

    public void updatePersona(Integer idPersona, PersonaDto updatePersonaDto) throws Exception{
        PersonaEntity existePersona = personaService.findById(idPersona);
        if (existePersona == null){
            throw new Exception("Persona no encontrada");
        }
        existePersona.setNombres(updatePersonaDto.getNombres());
        existePersona.setApellidos(updatePersonaDto.getApellidos());
        existePersona.setEmail(updatePersonaDto.getEmail());
        existePersona.setTelefono(updatePersonaDto.getTelefono());
        this.personaService.update(existePersona);
    }

    public void deletePersona(Integer idPersona) throws Exception{
        PersonaEntity exsitePersona = personaService.findById(idPersona);
        if (exsitePersona == null){
            throw new Exception("Persona no encontrada");
        }
        this.personaService.delete(exsitePersona);
    }
}
