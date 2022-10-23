package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.DetalleVenta;

import java.util.List;

public interface DetalleVentaRepository
    extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findById(long id);
}
