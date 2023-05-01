package org.cuentas.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String numero_cuenta;
    private String tipo_cuenta;
    private float saldo_inicial;
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "cuenta_cliente_fk"))
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimiento> movimientos = new ArrayList<>();

    public String getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numero_cuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipo_cuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipo_cuenta = tipoCuenta;
    }

    public float getSaldoInicial() {
        return saldo_inicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldo_inicial = saldoInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    

}
