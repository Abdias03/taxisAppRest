package com.taxis.app.service;

import java.util.List;

import com.taxis.app.dto.UsuariosDto;

public interface UsuariosService {
	
	  // Crear un nuevo usuario
	UsuariosDto createUsuarios(UsuariosDto usuariosDto);
	
	 // Actualizar un usuario existente
    UsuariosDto updateUsuarios(Long id, UsuariosDto usuariosDto);

    // Eliminar un usuario por su ID
    void deleteUsuarios(Long id);

    // Obtener un usuario por su ID
    UsuariosDto getUsuariosById(Long id);

    // Obtener todos los usuarios
    List<UsuariosDto> getAllUsuarios();
}
