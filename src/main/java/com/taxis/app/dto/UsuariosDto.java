package com.taxis.app.dto;

public class UsuariosDto {
	
	   private Long id;
	    private String nombre;
	    private String correo;
	    private String telefono;
	    private String tipo;
	    private String contrasena;
	    private Boolean verificado;
	    private String createdAt;

	    // Constructor sin parámetros
	    public UsuariosDto() {
	    }

	    // Constructor con todos los parámetros
	    public UsuariosDto(Long id, String nombre, String correo, String telefono, String tipo, String contrasena, Boolean verificado, String createdAt) {
	        this.id = id;
	        this.nombre = nombre;
	        this.correo = correo;
	        this.telefono = telefono;
	        this.tipo = tipo;
	        this.contrasena = contrasena;
	        this.verificado = verificado;
	        this.createdAt = createdAt;
	    }

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

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
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

	    public String getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(String createdAt) {
	        this.createdAt = createdAt;
	    }

}
