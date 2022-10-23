package pe.com.babelfarma.babelfarmabackend.entities;
import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @OneToMany(mappedBy = "role")
    private List<Usuario> usuarios;

    public Role(){}

    public Role(int id , String rol)
    {
        this.id = id;
        this.role= role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String rol) {
        this.role = rol;
    }
}

