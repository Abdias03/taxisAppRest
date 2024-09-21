package com.taxis.app.service;

import com.taxis.app.dto.UsuariosDto;
import com.taxis.app.entity.Usuarios;
import com.taxis.app.entity.Usuarios.Tipo;
import com.taxis.app.mapper.UsuariosMapper;
import com.taxis.app.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UsuariosDto createUsuarios(UsuariosDto usuariosDto) {
        Usuarios usuario = UsuariosMapper.mapToUsuarios(usuariosDto);
        Usuarios savedUsuario = usuariosRepository.save(usuario);
        return UsuariosMapper.mapToUsuariosDto(savedUsuario);
    }

    @Override
    public UsuariosDto updateUsuarios(Long id, UsuariosDto usuariosDto) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    // Actualiza los campos del usuario
                    usuario.setNombre(usuariosDto.getNombre());
                    usuario.setCorreo(usuariosDto.getCorreo());
                    usuario.setTelefono(usuariosDto.getTelefono());
                    usuario.setTipo(Tipo.fromString(usuariosDto.getTipo()));
                    usuario.setContrasena(usuariosDto.getContrasena());
                    usuario.setVerificado(usuariosDto.getVerificado());
                    // Guarda el usuario actualizado
                    return UsuariosMapper.mapToUsuariosDto(usuariosRepository.save(usuario));
                }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Override
    public void deleteUsuarios(Long id) {
        if (!usuariosRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        usuariosRepository.deleteById(id);
    }

    @Override
    public UsuariosDto getUsuariosById(Long id) {
        return usuariosRepository.findById(id)
                .map(UsuariosMapper::mapToUsuariosDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Override
    public List<UsuariosDto> getAllUsuarios() {
        return usuariosRepository.findAll().stream()
                .map(UsuariosMapper::mapToUsuariosDto)
                .collect(Collectors.toList());
    }

   
	
}
