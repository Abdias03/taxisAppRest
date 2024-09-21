package com.taxis.app.mapper;

import java.sql.Timestamp;

import com.taxis.app.dto.UsuariosDto;
import com.taxis.app.entity.Usuarios;
import com.taxis.app.entity.Usuarios.Tipo;

public class UsuariosMapper {
	
	public static UsuariosDto mapToUsuariosDto(Usuarios usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuariosDto(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getCorreo(),
            usuario.getTelefono(),
            usuario.getTipo().name(),
            usuario.getContrasena(),
            usuario.getVerificado(),
            usuario.getCreatedAt().toString()
        );
    }

    public static Usuarios mapToUsuarios(UsuariosDto dto) {
        if (dto == null) {
            return null;
        }
        Usuarios usuario = new Usuarios();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setTelefono(dto.getTelefono());
        usuario.setTipo(Tipo.fromString(dto.getTipo()));
        usuario.setContrasena(dto.getContrasena());
        usuario.setVerificado(dto.getVerificado());
        usuario.setCreatedAt(Timestamp.valueOf(dto.getCreatedAt()));
        
        return usuario;
    }

}
