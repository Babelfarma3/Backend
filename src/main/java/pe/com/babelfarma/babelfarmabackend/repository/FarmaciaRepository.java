package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Farmacia;

import java.util.List;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
  List<Farmacia> findById(long id);
  List<Farmacia> findByDireccion(String direccion);
}
