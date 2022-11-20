package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Venta;

import java.util.List;

public interface VentaRepository
    extends JpaRepository<Venta, Long> {
    List<Venta> findById(long id);

    @Query(value = "select * from venta v where v.id_farmacia=?1", nativeQuery = true)
    List<Venta> findByFarmaciaId(Long id);

}
