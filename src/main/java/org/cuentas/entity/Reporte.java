package org.cuentas.entity;

import java.time.LocalDateTime;

public class Reporte {
    // private Long id;
    // private LocalDateTime fechInicio;
    // private LocalDateTime fechaFin;
    private LocalDateTime fecha;
    private String nombre;
    private String numero_cuenta;
    private String tipo;
    private float saldo_inicial;
    private String estado;
    private String movimiento;
    private String saldo_disponible;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(float saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getSaldo_disponible() {
        return saldo_disponible;
    }

    public void setSaldo_disponible(String saldo_disponible) {
        this.saldo_disponible = saldo_disponible;
    }

    @Override
    public String toString() {
        return "Reporte [fecha=" + fecha + ", nombre=" + nombre + ", numero_cuenta=" + numero_cuenta + ", tipo=" + tipo
                + ", saldo_inicial=" + saldo_inicial + ", estado=" + estado + ", movimiento=" + movimiento
                + ", saldo_disponible=" + saldo_disponible + "]";
    }

}
