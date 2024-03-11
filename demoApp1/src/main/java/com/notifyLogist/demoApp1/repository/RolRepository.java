package com.notifyLogist.demoApp1.repository;

import com.notifyLogist.demoApp1.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {
    @Query(value = "select r from RolEntity r where r.idRol=:idRol")
    public Optional<RolEntity> findById(Integer idRol);
}
