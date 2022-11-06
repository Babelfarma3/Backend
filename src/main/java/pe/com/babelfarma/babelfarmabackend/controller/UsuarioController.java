package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.entities.Usuario;
import pe.com.babelfarma.babelfarmabackend.repository.UsuarioRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario newUsuario =
                usuarioRepository.save(new Usuario(
                   usuario.getUsuario(),
                   usuario.getContraseña(),
                   usuario.getRole()
                )
        );
        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
    }
}
