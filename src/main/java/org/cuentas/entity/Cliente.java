package org.cuentas.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Persona {
    private String contrasenia;
    private boolean estado;

    // @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(foreignKey = @ForeignKey(name = "cuenta_cliente_fk"))
    // @OnDelete(action = OnDeleteAction.RESTRICT)
    // private List<Cuenta> cuentas = new ArrayList<>();

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // public List<Cuenta> getCuentas() {
    //     return cuentas;
    // }

    // public void setCuentas(List<Cuenta> cuentas) {
    //     this.cuentas = cuentas;
    // }
    
}
