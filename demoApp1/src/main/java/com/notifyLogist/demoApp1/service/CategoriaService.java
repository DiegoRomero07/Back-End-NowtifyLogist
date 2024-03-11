package com.notifyLogist.demoApp1.service;


import com.notifyLogist.demoApp1.entity.CategoriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {

    List<CategoriaEntity> getAll();

    CategoriaEntity findById(Integer idCategoria);
    void create(CategoriaEntity categoriaEntity);
    void delete(CategoriaEntity categoriaEntity);

    default boolean exists(int idCategoria) {
        return false;
    }

}
