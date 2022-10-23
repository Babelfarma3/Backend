package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Farmacia;

import java.util.List;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {


  @Query("SELECT f FROM Farmacia f WHERE f.id = ?1")
  Farmacia findByIdJPQL(Long id);

  @Query(value = "SELECT * FROM farmacias WHERE direccion LIKE '%'||?1||'%'", nativeQuery = true)
  List<Farmacia> findByDistritoContainingSQL(String distrito);



}
