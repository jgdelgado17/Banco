package org.cuentas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.cuentas.entity.Reporte;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ReporteService {
    @PersistenceContext
    EntityManager manager;

    public List<Reporte> reporte() {
        String query = "SELECT mv.fecha, cl.nombre,ct.numero_cuenta, ct.tipo_cuenta, mv.saldo_inicial, ct.estado, mv.valor, ct.saldo FROM cliente cl join cuenta ct on cl.id = ct.cliente_id join movimiento mv on ct.id = mv.cuenta_id WHERE cl.id = 2 AND mv.fecha between '2023-05-01' AND '2023-05-03';";

        return manager.createQuery(query, Reporte.class)
                // .setParameter("id", id)
                // .setParameter("fechInicio", fechInicio)
                // .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
}
