package org.cuentas.repository;

import java.util.List;

import org.cuentas.entity.Persona;

public interface PersonaRepository {
    List<Persona> findAll();
    // Persona findOne(int id);
    // Persona save(Persona persona);
}
