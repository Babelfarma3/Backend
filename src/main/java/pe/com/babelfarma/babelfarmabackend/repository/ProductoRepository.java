package pe.com.babelfarma.babelfarmabackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
