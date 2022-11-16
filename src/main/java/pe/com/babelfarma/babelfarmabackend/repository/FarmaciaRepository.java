package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Farmacia;

import javax.transaction.Transactional;
import java.util.List;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {


  @Query("SELECT f FROM Farmacia f WHERE f.id = ?1")
  Farmacia findByIdJPQL(Long id);

  @Query(value = "SELECT * FROM farmacias WHERE direccion LIKE '%'||?1||'%'", nativeQuery = true)
  List<Farmacia> findByDireccionContainingSQL(String direccion);

  @Query(value = "SELECT * FROM farmacias WHERE nombre_establecimiento LIKE '%'||?1||'%'", nativeQuery = true)
  List<Farmacia> findByNombreEstablecimientoContainingSQL(String nombreEstablecimiento);

  @Query("SELECT f FROM Farmacia f JOIN f.distrito fd WHERE f.distrito.nombreDistrito= ?1")
  List<Farmacia> findByDistritoContainingJPQL(String distrito);

  @Query(value = "SELECT f.nombre_establecimiento, p.nombre, p.stock FROM farmacias f INNER JOIN farmacias_productos ON farmacias_productos.farmacia_id = f.id INNER JOIN productos p ON p.id = farmacias_productos.producto_id", nativeQuery = true)
  List<String> findProducsByStock();


  @Query("SELECT f FROM Farmacia f WHERE f.correoContacto=?1")
  Farmacia findByCorreoYContraseña(String correo);



}
