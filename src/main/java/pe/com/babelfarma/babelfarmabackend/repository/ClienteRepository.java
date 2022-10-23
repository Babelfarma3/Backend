package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Cliente;

import java.util.List;

public interface ClienteRepository
    extends JpaRepository<Cliente, Long> {
    List<Cliente> findById(long id);
    List<Cliente> findByDni(int dni);
    List<Cliente> findBySexo(String sexo);
}
