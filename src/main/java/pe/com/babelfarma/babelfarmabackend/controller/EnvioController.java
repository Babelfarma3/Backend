package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.repository.EnvioRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Envio;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnvioController {
    @Autowired
    private EnvioRepository envioRepository;
    @GetMapping("/envios")
    public ResponseEntity<List<Envio>> getAllEnvios(){
        List<Envio> envios = envioRepository.findAll();
        return new ResponseEntity<List<Envio>>(envios, HttpStatus.OK);
    }
    @PostMapping("/envios")
    public ResponseEntity<Envio> createEnvio(@RequestBody Envio envio){
        Envio newEnvio =
                envioRepository.save(new Envio(
                    envio.getNombreEncargado(),
                    envio.getApellidoEncargado(),
                    envio.getCelular(),
                    envio.getDireccionEnvio(),
                    envio.getVenta()
                )
        );
        return new ResponseEntity<Envio>(newEnvio, HttpStatus.CREATED);
    }
}
