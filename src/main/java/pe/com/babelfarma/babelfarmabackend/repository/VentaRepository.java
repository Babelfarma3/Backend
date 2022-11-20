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

    @Query(value="select * from venta v inner join cliente c on v.id_cliente = c.id " +
            "inner join farmacias f on v.id_farmacia=f.id where c.nombres like '%'||?1||'%' and f.id=?2", nativeQuery=true)
    List<Venta> findByNombreCliente(String nombre, Long id);

}
