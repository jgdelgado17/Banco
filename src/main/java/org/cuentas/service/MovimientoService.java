package org.cuentas.service;

import java.util.List;

import org.cuentas.entity.Cuenta;
import org.cuentas.entity.Movimiento;
import org.cuentas.repository.MovimientoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MovimientoService {

    @Inject
    MovimientoRepository repository;

    @Inject
    CuentaService cuentaService;

    public List<Movimiento> findAll() {
        return repository.listAll();
    }

    public Movimiento findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Movimiento save(Movimiento movimiento) {

        Long id_cuenta = movimiento.getCuenta().getId();
        Cuenta cuenta_asociada = cuentaService.findById(id_cuenta);

        if (cuenta_asociada != null) {
            float saldo_inicial = cuenta_asociada.getSaldo_inicial();
            String tipo_movimiento = movimiento.getTipo_movimiento();

            movimiento.setSaldo_inicial(saldo_inicial);

            switch (tipo_movimiento) {
                case "Retiro":
                    cuenta_asociada.setSaldo_inicial(saldo_inicial - movimiento.getValor());
                    break;
                case "Deposito":
                    cuenta_asociada.setSaldo_inicial(saldo_inicial + movimiento.getValor());
                    break;
            }
            cuentaService.update(id_cuenta, cuenta_asociada);
        }

        repository.persist(movimiento);
        return movimiento;
    }

    @Transactional
    public Movimiento update(Long id, Movimiento movimiento) {
        Movimiento upMovimiento = repository.findById(id);
        upMovimiento.setFecha(movimiento.getFecha());
        upMovimiento.setTipo_movimiento(movimiento.getTipo_movimiento());
        upMovimiento.setValor(movimiento.getValor());
        upMovimiento.setSaldo_inicial(movimiento.getSaldo_inicial());
        upMovimiento.setCuenta(movimiento.getCuenta());
        repository.persist(upMovimiento);
        return upMovimiento;
    }

    @Transactional
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
