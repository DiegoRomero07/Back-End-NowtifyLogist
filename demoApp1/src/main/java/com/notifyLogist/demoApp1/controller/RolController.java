package com.notifyLogist.demoApp1.controller;

import com.notifyLogist.demoApp1.business.RolBusiness;
import com.notifyLogist.demoApp1.dtos.RolDto;
import com.notifyLogist.demoApp1.entity.RolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Rol", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin("*")
public class RolController {

    private RolBusiness rolBusiness;

    @Autowired
    public RolController(RolBusiness rolBusiness){this.rolBusiness = rolBusiness;}

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        List<RolDto> listRol = this.rolBusiness.getAll();
        response.put("Status", "Success");
        response.put("Data", listRol);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{idRol}")


    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> add(@RequestBody RolDto rolDto){
        Map<String, Object> response = new HashMap<>();
        try{
            rolBusiness.createRol(rolDto);
            response.put("Status", "Success");
            response.put("data", rolDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{idRol}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int idRol,
                                                      @RequestBody RolDto rolDto){
        Map<String, Object> response = new HashMap<>();
        try{
            rolBusiness.updateRol(idRol,rolDto);
            response.put("Status", "Success");
            response.put("data", rolDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{idRol}")
    public ResponseEntity<Map<String, Object>> deleteRol(@PathVariable int idRol){
        Map<String, Object> response = new HashMap<>();
        try{
            rolBusiness.deleteRol(idRol);
            response.put("Status", "Success");
            response.put("message", "Rol Eliminado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
