package br.com.senac.api.controllers;

import br.com.senac.api.dtos.UsuariosRequestDto;
import br.com.senac.api.services.UsuariosService;
import br.com.senac.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuariosRequestDto usuario){
        try {
            return ResponseEntity.ok(usuariosService.login(usuario));
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(ResponseUtil.parserMensagem(e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(ResponseUtil.parserMensagem(e.getMessage()));
        }

    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> criar(@RequestBody UsuariosRequestDto usuario){
        try {
            return ResponseEntity.ok(usuariosService.criar(usuario));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(ResponseUtil.parserMensagem(e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(ResponseUtil.parserMensagem(e.getMessage()));
        }
    }
}
