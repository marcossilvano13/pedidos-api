package br.com.senac.api.services;

import br.com.senac.api.dtos.TokenResponseDtos;
import br.com.senac.api.dtos.UsuariosRequestDto;
import br.com.senac.api.entidades.Usuarios;
import br.com.senac.api.jwt.JwtService;
import br.com.senac.api.respositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public Usuarios criar(UsuariosRequestDto usuario){
        return usuariosRepositorio.save(this.usuariosRequestDtoParaUsuarios(usuario));
    }

    public TokenResponseDtos login(UsuariosRequestDto usuario){
        Optional<Usuarios> usuarioRetorno = usuariosRepositorio.findByEmail(usuario.getEmail());
        if (usuarioRetorno.isPresent()){
            Usuarios usuarioDb = usuarioRetorno.get();
            if (passwordEncoder.matches(usuario.getSenha(), usuarioDb.getSenha())){
                return new TokenResponseDtos(jwtService.gerarToken(usuarioDb));
            }
            throw new RuntimeException("Senha Inválida!");

        }

        throw new RuntimeException("Usuário não Encontrado!");
    }

    public Usuarios usuariosRequestDtoParaUsuarios(UsuariosRequestDto entrada){
        Usuarios saida = new Usuarios();
        saida.setNome(entrada.getNome());
        saida.setEmail(entrada.getEmail());
        saida.setSenha(passwordEncoder.encode(entrada.getSenha()));
        return saida;
    }


}
