package com.taxis.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
    public Usuarios() {
        super();
    }

    public Usuarios(Long id, String nombre, String correo, String telefono, Tipo tipo, String contrasena, Boolean verificado, Timestamp createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.verificado = verificado;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(length = 15)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo;  // Enum para 'cliente' o 'conductor'

    @Column(nullable = false, length = 255)
    private String contrasena;

    @Column(nullable = false)
    private Boolean verificado = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // Enum para el campo 'tipo'
    public enum Tipo {
        CLIENTE,
        CONDUCTOR;

        public static Tipo fromString(String tipo) {
            if (tipo == null) {
                return null;
            }
            for (Tipo t : Tipo.values()) {
                if (t.name().equalsIgnoreCase(tipo)) {
                    return t;
                }
            }
            throw new IllegalArgumentException("Tipo de usuario no válido: " + tipo);
        }
    }

}
