package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.babelfarma.babelfarmabackend.entities.Envio;

import java.util.List;

public interface EnvioRepository
    extends JpaRepository<Envio, Long> {
        List<Envio> findById(long id);
        List<Envio> findByDireccionEnvio(String direccionEnvio);
}
