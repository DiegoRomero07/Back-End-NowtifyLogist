package com.notifyLogist.demoApp1.controller;

import com.notifyLogist.demoApp1.business.PersonaBusiness;
import com.notifyLogist.demoApp1.dtos.PersonaDto;
import com.notifyLogist.demoApp1.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Persona", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin("*")
public class PersonaController {
    private final PersonaBusiness personaBusiness;

    @Autowired
    public PersonaController(PersonaBusiness personaBusiness){
        this.personaBusiness = personaBusiness;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        List<PersonaDto> listPersona = this.personaBusiness.getAll();
        response.put("Status", "Success");
        response.put("Data", listPersona);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all/{idPersona}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Integer idPersona){
        try {
            PersonaEntity personaEntity = personaBusiness.findById(idPersona);
            Map<String, Object> response = new HashMap<>();
            response.put("Status", "Success");
            response.put("data", personaEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            Map<String, Object> response = new HashMap<>();
            response.put("Status", "Success");
            response.put("Message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> add(@RequestBody PersonaDto personaDto){
        Map<String, Object> response = new HashMap<>();
        try{
            personaBusiness.createPersona(personaDto);
            response.put("Status", "Success");
            response.put("data", personaDto);
            return  new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{idPersona}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int idPersona,
                                                      @RequestBody PersonaDto personaDto){
        Map<String, Object> response = new HashMap<>();
        try{
            personaBusiness.updatePersona(idPersona, personaDto);
            response.put("Status", "Success");
            response.put("data", personaDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idPersona}")
    public  ResponseEntity<Map<String, Object>> deletePersona(@PathVariable int idPersona){
        Map<String, Object> response = new HashMap<>();
        try {
            personaBusiness.deletePersona(idPersona);
            response.put("Status", "Success");
            response.put("messge", "Persona eliminada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
