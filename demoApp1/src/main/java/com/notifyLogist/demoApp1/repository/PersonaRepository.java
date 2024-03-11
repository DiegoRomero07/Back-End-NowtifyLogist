package com.notifyLogist.demoApp1.repository;

import com.notifyLogist.demoApp1.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    @Query(value = "select p from PersonaEntity p where p.idPersona=:idPersona")
    public Optional<PersonaEntity> findById(Integer idPersona);
}
