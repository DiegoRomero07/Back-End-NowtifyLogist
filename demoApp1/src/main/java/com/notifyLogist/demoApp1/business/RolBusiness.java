package com.notifyLogist.demoApp1.business;

import com.notifyLogist.demoApp1.dtos.RolDto;
import com.notifyLogist.demoApp1.entity.RolEntity;
import com.notifyLogist.demoApp1.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolBusiness {

    @Autowired
    private RolService rolService;

    private List<RolEntity> rolEntityList;

    private final List<RolDto> rolDtoList = new ArrayList<>();


    public List<RolDto> getAll(){
        this.rolEntityList = this.rolService.getAll();
        this.rolEntityList.stream().forEach(rolEntity -> {
            RolDto rolDto = new RolDto();
            rolDto.setIdRol(rolEntity.getIdRol());
            rolDto.setNombreRol(rolEntity.getNombreRol());
            rolDto.setDescripcionRol(rolEntity.getDescripcionRol());

            rolDtoList.add(rolDto);
        });
        return rolDtoList;
    }

    public RolEntity findById(Integer idRol){
        return this.rolService.findById(idRol);
    }

    public void createRol(RolDto rolDto) throws Exception{
        RolEntity rolEntity = new RolEntity();
        rolEntity.setNombreRol(rolDto.getNombreRol());
        rolEntity.setDescripcionRol(rolDto.getDescripcionRol());

        this.rolService.create(rolEntity);
    }

    public void updateRol(Integer idRol, RolDto updateRolDto) throws Exception{
        RolEntity existeRol = rolService.findById(idRol);
        if (existeRol == null){
            throw new Exception("Rol no encontrado");
        }
        existeRol.setNombreRol(updateRolDto.getNombreRol());
        existeRol.setDescripcionRol(updateRolDto.getDescripcionRol());
        this.rolService.update(existeRol);
    }

    public void deleteRol(Integer idRol) throws Exception{
        RolEntity existeRol = rolService.findById(idRol);
        if (existeRol == null){
            throw new Exception("Rol no encontrado");
        }
        this.rolService.delete(existeRol);
    }
}
