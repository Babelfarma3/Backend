package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Cliente;

import java.util.List;

public interface ClienteRepository
    extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.id=?1")
    Cliente findByIdJPQL(long id);
    @Query("SELECT c FROM Cliente c WHERE c.dni=?1")
    Cliente findByDniJPQL(int dni);
    @Query("SELECT c FROM Cliente c WHERE c.sexo=?1")
    List<Cliente> findBySexoJPQL(String sexo);
    //@Query("SELECT c FROM Cliente c WHERE DATEDIFF(CURRENT_TIMESTAMP(), c.fechaNacimiento) BETWEEN ?1 AND ?2")
    //@Query(value="SELECT * FROM public.cliente (DATE_PART('year', NOW()) - DATE_PART('year', fecha_nacimiento)) BETWEEN ||?1|| AND ||?2||", nativeQuery=true)
    //List<Cliente> findByEdadJPQL(int min, int max);
}
