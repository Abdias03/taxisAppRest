package com.taxis.app.controller;

import com.taxis.app.dto.UsuariosDto;
import com.taxis.app.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired
    private UsuariosService usuariosService;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UsuariosDto> createUsuario(@RequestBody UsuariosDto usuariosDto) {
        UsuariosDto createdUsuario = usuariosService.createUsuarios(usuariosDto);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    // Actualizar un usuario existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDto> updateUsuario(
            @PathVariable Long id,
            @RequestBody UsuariosDto usuariosDto) {
        UsuariosDto updatedUsuario = usuariosService.updateUsuarios(id, usuariosDto);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuariosService.deleteUsuarios(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> getUsuarioById(@PathVariable Long id) {
        UsuariosDto usuario = usuariosService.getUsuariosById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuariosDto>> getAllUsuarios() {
        List<UsuariosDto> usuarios = usuariosService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
