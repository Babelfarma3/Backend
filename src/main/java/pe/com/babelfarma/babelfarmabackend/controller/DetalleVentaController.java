package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.exception.ResourceNotFoundException;
import pe.com.babelfarma.babelfarmabackend.repository.DetalleVentaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.DetalleVenta;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    @GetMapping("/detallesVenta")
    public ResponseEntity<List<DetalleVenta>> getAllDetalleVentas() {
        List<DetalleVenta> detalleVentas = detalleVentaRepository.findAll();
        return new ResponseEntity<List<DetalleVenta>>(detalleVentas, HttpStatus.OK);
    }
    //post
    @PostMapping("/detallesVenta")
    public ResponseEntity<DetalleVenta> createDetallesVentas(@RequestBody DetalleVenta detalleVenta){
        DetalleVenta newDetalleVenta =
                detalleVentaRepository.save(new DetalleVenta(
                                detalleVenta.getCantidad(),
                                detalleVenta.getPrecioUnit(),
                                detalleVenta.getPrecioTotal()
                        )
                );
        return new ResponseEntity<DetalleVenta>(newDetalleVenta, HttpStatus.CREATED);
    }
    //put
    @PutMapping("/detallesVenta/{id}")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(
            @PathVariable("id") Long id,
            @RequestBody DetalleVenta detalleVenta){
        DetalleVenta detalleVentaUpdate = detalleVentaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No se encontró el cliente con id: " + id));
        detalleVentaUpdate.setCantidad(detalleVenta.getCantidad());
        detalleVentaUpdate.setPrecioUnit(detalleVenta.getPrecioUnit());
        detalleVentaUpdate.setPrecioTotal(detalleVenta.getPrecioTotal());
        return new ResponseEntity<DetalleVenta>(detalleVentaRepository.save(detalleVentaUpdate), HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/detallesVenta/{id}")
    public ResponseEntity<HttpStatus> deleteDetalleVenta(@PathVariable("id") Long id){
        detalleVentaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
