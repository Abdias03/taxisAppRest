package com.taxis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxis.app.entity.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
