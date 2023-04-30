package org.cuentas.repository;

import java.util.List;

import org.cuentas.entity.Persona;

public class PersonaRepositoryImpl implements PersonaRepository {

    @Override
    public List<Persona> findAll() {
        return Persona.listAll();
    }

    @Override
    public Persona findOne(Integer id) {
        return Persona.findById(id);
    }
    
}
