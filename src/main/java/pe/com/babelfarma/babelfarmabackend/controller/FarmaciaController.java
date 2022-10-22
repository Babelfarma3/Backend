package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.babelfarma.babelfarmabackend.entities.Farmacia;
import pe.com.babelfarma.babelfarmabackend.repository.FarmaciaRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmaciaController {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @GetMapping("/farmacias")
    public ResponseEntity<List<Farmacia>> getAllFarmacias(){
        List<Farmacia> farmacias = farmaciaRepository.findAll();

        return new ResponseEntity<List<Farmacia>>(farmacias, HttpStatus.OK);
    }



}
