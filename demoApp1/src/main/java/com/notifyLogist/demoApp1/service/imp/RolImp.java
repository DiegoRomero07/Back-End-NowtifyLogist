package com.notifyLogist.demoApp1.service.imp;

import com.notifyLogist.demoApp1.entity.RolEntity;
import com.notifyLogist.demoApp1.repository.RolRepository;
import com.notifyLogist.demoApp1.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolImp implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolEntity> getAll() {
        return this.rolRepository.findAll();
    }

    @Override
    public RolEntity findById(Integer idRol) {
        RolEntity rolEntity = this.rolRepository.getById(idRol);
        return rolEntity;
    }

    @Override
    public void create(RolEntity rolEntity) {
        this.rolRepository.save(rolEntity);
    }

    @Override
    public void update(RolEntity rolEntity) {
        this.rolRepository.save(rolEntity);
    }

    @Override
    public void delete(RolEntity rolEntity) {
        this.rolRepository.delete(rolEntity);
    }

    @Override
    public boolean exists(int idRol) {
        return false;
    }
}
