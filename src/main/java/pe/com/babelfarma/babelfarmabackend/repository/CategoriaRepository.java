package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
