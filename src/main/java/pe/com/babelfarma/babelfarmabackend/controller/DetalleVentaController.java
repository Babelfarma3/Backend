package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.babelfarma.babelfarmabackend.repository.DetalleVentaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.DetalleVenta;

import java.util.List;

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
}
