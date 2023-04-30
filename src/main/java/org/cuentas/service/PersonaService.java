package org.cuentas.service;

import java.util.List;

import org.cuentas.entity.Persona;
import org.cuentas.repository.PersonaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PersonaService {

    @Inject
    PersonaRepository repository;

    public List<Persona> findAll() {
        return repository.findAll();
    }

}
