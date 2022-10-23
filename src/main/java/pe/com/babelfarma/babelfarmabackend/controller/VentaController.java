package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.repository.VentaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Venta;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VentaController {
    @Autowired
    private VentaRepository ventaRepository;
    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> getAllVentas(){
        List<Venta> ventas = ventaRepository.findAll();
        return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
    }
    @PostMapping("/ventas")
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta){
        Venta newVenta =
                ventaRepository.save(new Venta(
                        venta.getFecha(),
                        venta.getCliente(),
                        venta.getFarmacia()
                )
        );
        return new ResponseEntity<Venta>(newVenta, HttpStatus.CREATED);
    }

    //put

    //deletee
}


