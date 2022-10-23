package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Venta;

import java.util.List;

public interface VentaRepository
    extends JpaRepository<Venta, Long> {
    List<Venta> findById(long id);
}
