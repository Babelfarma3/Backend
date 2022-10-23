package pe.com.babelfarma.babelfarmabackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.entities.Categoria;
import pe.com.babelfarma.babelfarmabackend.entities.Producto;
import pe.com.babelfarma.babelfarmabackend.exception.ResourceNotFoundException;
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

    @PostMapping("/productos")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        Producto newProducto=
                productoRepository.save(
                        new Producto(
                                producto.getNombre(),
                                producto.getStock(),
                                producto.getPrecio(),
                                producto.getDescripcion(),
                                producto.getCategoria()
                        )
                );
        return new ResponseEntity<Producto>(newProducto, HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long id,
                                                   @RequestBody Producto producto){
        Producto productoUpdate = productoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No se encontró el producto con id: " + id));
        productoUpdate.setNombre(producto.getNombre());
        productoUpdate.setStock(producto.getStock());
        productoUpdate.setPrecio(producto.getPrecio());
        productoUpdate.setDescripcion(producto.getDescripcion());
        productoUpdate.setCategoria(producto.getCategoria());
        return new ResponseEntity<Producto>(productoRepository.save(productoUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") Long id){
        productoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/productos/buscarproducto/{producto}")
    public ResponseEntity<List<Producto>> getProductosSearch(@PathVariable("producto") String producto){
        List<Producto> productos=productoRepository.findProductoSQL(producto);
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }


    @GetMapping("/productos/categorias")
    public ResponseEntity<List<String>> ListarCantProdCategoria(){
        List<String> productos=productoRepository.ListCantProdCategoriaJPQL();
        return new ResponseEntity<List<String>>(productos, HttpStatus.OK);
    }

    @GetMapping("/productos/stock")
    public ResponseEntity<List<Producto>> getProductosStock(){
        List<Producto> productos=productoRepository.ListProductoStockJPQL();
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    @GetMapping("/productos/precio")
    public ResponseEntity<List<Producto>> getProductosPrecio(){
        List<Producto> productos=productoRepository.ListProductoPrecioJPQL();
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

}
