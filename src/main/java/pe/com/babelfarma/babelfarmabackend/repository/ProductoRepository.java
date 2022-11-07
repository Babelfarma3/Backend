package pe.com.babelfarma.babelfarmabackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Categoria;
import pe.com.babelfarma.babelfarmabackend.entities.Cliente;
import pe.com.babelfarma.babelfarmabackend.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    @Query(value="SELECT * FROM productos where nombre like '%'||?1||'%'", nativeQuery = true)
    List<Producto> findProductoSQL(String producto);


    @Query("SELECT p FROM Producto p WHERE p.id=?1")
    Producto FindById(Long id);
    @Query("select p.categoria.categoria, p.stock from Producto p join p.categoria c where c.id = p.categoria.id")
    List<String> ListCantProdCategoriaJPQL();

    @Query("select p from Producto p order by p.stock desc")
    List<Producto> ListProductoStockJPQL();

    @Query("select p from Producto p order by p.precio asc")
    List<Producto> ListProductoPrecioJPQL();

    //Reporte de productos mas vendidos


}
