package pe.com.babelfarma.babelfarmabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.babelfarma.babelfarmabackend.entities.Cliente;
import pe.com.babelfarma.babelfarmabackend.entities.Farmacia;
import pe.com.babelfarma.babelfarmabackend.exception.ResourceNotFoundException;
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

    @GetMapping("/farmacias/buscarid/{buscarid}")
    public ResponseEntity<Farmacia> findById(
            @PathVariable("buscarid") Long id){
       Farmacia farmacia = farmaciaRepository.findByIdJPQL(id);

        return new ResponseEntity<Farmacia>(farmacia, HttpStatus.OK);
    }

    @GetMapping("/farmacias/buscardistrito/{distrito}")
    public ResponseEntity<List<Farmacia>> findByDistrito(
            @PathVariable("distrito") String distrito
    ){

        List<Farmacia> farmacias = farmaciaRepository.findByDistritoContainingSQL(distrito);

        return new ResponseEntity<List<Farmacia>>(farmacias, HttpStatus.OK);
    }

    @PostMapping("/farmacias")
    public ResponseEntity<Farmacia> createFarmacia(@RequestBody Farmacia farmacia){
        Farmacia newFarmacia =
                farmaciaRepository.save(new Farmacia(
                        farmacia.getRUC(),
                        farmacia.getNombreEstablecimiento(),
                        farmacia.getDireccion(),
                        farmacia.getCorreoContato(),
                        farmacia.getTelefonoContacto()
                        )
                );
        return new ResponseEntity<Farmacia>(newFarmacia, HttpStatus.CREATED);
    }
    @PutMapping("/farmacias/{id}")
    public ResponseEntity<Farmacia> updateFarmacia(
            @PathVariable("id") Long id,
            @RequestBody Farmacia farmacia){
        Farmacia farmaciaUpdate = farmaciaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No se encontró el cliente con id: " + id));
        farmaciaUpdate.setRUC(farmacia.getRUC());
        farmaciaUpdate.setNombreEstablecimiento(farmacia.getNombreEstablecimiento());
        farmaciaUpdate.setDireccion(farmacia.getDireccion());
        farmaciaUpdate.setCorreoContato(farmacia.getCorreoContato());
        farmaciaUpdate.setTelefonoContacto(farmacia.getTelefonoContacto());

        return new ResponseEntity<Farmacia>(farmaciaRepository.save(farmaciaUpdate), HttpStatus.OK);
    }
    @DeleteMapping("/farmacias/{id}")
    public ResponseEntity<HttpStatus> deleteFarmacia(@PathVariable("id") Long id){
        farmaciaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
