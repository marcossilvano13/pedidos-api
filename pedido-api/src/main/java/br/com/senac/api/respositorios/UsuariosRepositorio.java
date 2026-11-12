package br.com.senac.api.respositorios;

import br.com.senac.api.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByEmail(String email);
}
