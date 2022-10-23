package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.babelfarma.babelfarmabackend.entities.Distrito;
import pe.com.babelfarma.babelfarmabackend.repository.DistritoRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistritoController {
    @Autowired
    private DistritoRepository distritoRepository;
    @GetMapping("/distritos")
    private ResponseEntity<List<Distrito>> getAllDistritos(){
        List<Distrito> distritos = distritoRepository.findAll();
        return new ResponseEntity<List<Distrito>>(distritos, HttpStatus.OK);
    }

}
