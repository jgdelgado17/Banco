package org.cuentas.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ReporteService {
    @PersistenceContext
    EntityManager manager;
}
