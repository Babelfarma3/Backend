package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.entities.Categoria;
import pe.com.babelfarma.babelfarmabackend.repository.CategoriaRepository;
import pe.com.babelfarma.babelfarmabackend.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();

        return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
    }

    @GetMapping("/categorias/buscarcategoria/{categoria}")
    public ResponseEntity<List<Categoria>> getCategoriaSearch(@PathVariable("categoria") String categoria){
        List<Categoria> categorias = categoriaRepository.findCategoriaSQL(categoria);
        return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
    }


}
