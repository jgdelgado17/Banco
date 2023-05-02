package org.cuentas.service;

import java.util.List;

import org.cuentas.entity.Movimiento;
import org.cuentas.repository.MovimientoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MovimientoService {
    
    @Inject
    MovimientoRepository repository;

    public List<Movimiento> findAll() {
        return repository.listAll();
    }

    public Movimiento findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Movimiento save(Movimiento movimiento) {
        repository.persist(movimiento);
        return movimiento;
    }

    @Transactional
    public Movimiento update(Long id, Movimiento movimiento) {
        Movimiento upMovimiento = repository.findById(id);
        upMovimiento.setFecha(movimiento.getFecha());
        upMovimiento.setTipo_movimiento(movimiento.getTipo_movimiento());
        upMovimiento.setValor(movimiento.getValor());
        upMovimiento.setSaldo(movimiento.getSaldo());
        upMovimiento.setCuenta(movimiento.getCuenta());
        repository.persist(upMovimiento);
        return upMovimiento;
    }

    @Transactional
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
