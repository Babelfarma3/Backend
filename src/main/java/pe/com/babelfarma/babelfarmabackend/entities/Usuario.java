package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String usuario;
    private String contraseña;

    public Usuario(String usuario, String contraseña, Role role) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name="id_role", nullable=false)
    private Role role;

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}