package com.notifyLogist.demoApp1.service;


import com.notifyLogist.demoApp1.entity.RolEntity;

import java.util.List;

public interface RolService {

    List<RolEntity> getAll();

    RolEntity findById(Integer idRol);

    void create(RolEntity rolEntity);
    void update(RolEntity rolEntity);
    void delete(RolEntity rolEntity);

    default boolean exists(int idRol){return false;}
}
