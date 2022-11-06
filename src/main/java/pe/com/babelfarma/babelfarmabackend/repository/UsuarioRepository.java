package pe.com.babelfarma.babelfarmabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.babelfarma.babelfarmabackend.entities.Cliente;
import pe.com.babelfarma.babelfarmabackend.entities.Usuario;

public interface UsuarioRepository
    extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.id=?1")
    Usuario findByIdJPQL(long id);
    @Query("SELECT u FROM Usuario u WHERE u.usuario=?1")
    Usuario findByCorreoJPQL(String correo);

}
