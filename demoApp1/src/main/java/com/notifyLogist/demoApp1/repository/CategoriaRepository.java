package com.notifyLogist.demoApp1.repository;

import com.notifyLogist.demoApp1.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    @Query(value = "select c from CategoriaEntity c WHERE c.idCategoria= :idCategoria")
    public Optional<CategoriaEntity> findById(Integer idCategoria);
}
