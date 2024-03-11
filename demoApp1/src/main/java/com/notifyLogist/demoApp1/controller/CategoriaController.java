package com.notifyLogist.demoApp1.controller;

import com.notifyLogist.demoApp1.business.CategoriaBusiness;
import com.notifyLogist.demoApp1.dtos.CategoriaDto;
import com.notifyLogist.demoApp1.entity.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/categoria", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class CategoriaController {

    private CategoriaBusiness categoriaBusiness;
    @Autowired
    public CategoriaController(CategoriaBusiness categoriaBusiness){
        this.categoriaBusiness = categoriaBusiness;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        List<CategoriaDto> listCategoria = this.categoriaBusiness.getAll();
        response.put("Status", "Success");
        response.put("Data", listCategoria);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Map<String, Object>> getCategoriaById(@PathVariable Integer idCategoria){
        try{
            CategoriaEntity data = categoriaBusiness.findById(idCategoria);
            Map<String, Object> response = new HashMap<>();
            response.put("Static", "Succes");
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            Map<String, Object> response = new HashMap<>();
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> add(@RequestBody CategoriaDto categoria){
        Map<String, Object> response = new HashMap<>();
        try{
            categoriaBusiness.createCategoria(categoria);
            response.put("Status", "Success");
            response.put("data", categoria);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   @PutMapping("/update/{idCategoria}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int idCategoria,
           @RequestBody CategoriaDto categoria){
        Map<String, Object> response = new HashMap<>();
        try {
            categoriaBusiness.updateCategoria(idCategoria, categoria);
            response.put("Status", "Succes");
            response.put("data", categoria);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
   @DeleteMapping("/delete/{idCategoria}")
   public ResponseEntity<Map<String, Object>> deleteCategoria(@PathVariable int idCategoria){
        Map<String,Object> response = new HashMap<>();
        try{
            categoriaBusiness.deleteCategoria(idCategoria);
            response.put("Status", "Success");
            response.put("message", "Categoria Eliminada");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("Status", "Success");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}
