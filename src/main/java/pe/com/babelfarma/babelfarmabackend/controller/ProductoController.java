package pe.com.babelfarma.babelfarmabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.babelfarma.babelfarmabackend.entities.Producto;
import pe.com.babelfarma.babelfarmabackend.repository.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    //@GetMapping -> get
    //@PostMapping -> post
    //@PutMapping -> put
    //@DeleteMapping -> delete

    //Inyectar dependencia
    @Autowired
    private ProductoRepository productoRepository;
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos(){
        List<Producto> productos=productoRepository.findAll();

        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }
}
