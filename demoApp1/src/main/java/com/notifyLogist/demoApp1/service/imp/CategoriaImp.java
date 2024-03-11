package com.notifyLogist.demoApp1.service.imp;

import com.notifyLogist.demoApp1.entity.CategoriaEntity;
import com.notifyLogist.demoApp1.repository.CategoriaRepository;
import com.notifyLogist.demoApp1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> getAll() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity findById(Integer idCategoria) {
        CategoriaEntity categoriaEntity =this.categoriaRepository.getById(idCategoria);
        return categoriaEntity;
    }

    @Override
    public void create(CategoriaEntity categoriaEntity) {
        this.categoriaRepository.save(categoriaEntity);
    }
    @Override
    public void delete(CategoriaEntity categoriaEntity) {
        this.categoriaRepository.delete(categoriaEntity);
    }
    @Override
    public boolean exists(int idCategoria) {
        return false;
    }
}
