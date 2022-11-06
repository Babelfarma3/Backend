package pe.com.babelfarma.babelfarmabackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farmacias")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int RUC;

    private String nombreEstablecimiento;

    private String direccion;
    private String correoContato;
    private int telefonoContacto;

    private String contraseña;

    @OneToOne
    @JoinColumn(name = "id_role", nullable =false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="id_distrito", nullable=false)
    private Distrito distrito;

    @ManyToMany
            @JoinTable(name = "farmacias_productos",
                    joinColumns = @JoinColumn(name = "farmacia_id", referencedColumnName = "id", nullable = false),
                    inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id",nullable = false))
    List<Producto> productos = new ArrayList<>();



    public Farmacia() {
    }

    public Farmacia(int RUC, String nombreEstablecimiento, String direccion, String correoContato, int telefonoContacto, Distrito distrito,
                    Role role, String contraseña) {
        this.RUC = RUC;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.direccion = direccion;
        this.correoContato = correoContato;
        this.telefonoContacto = telefonoContacto;
        this.distrito = distrito;
        this.role=role;
        this.contraseña=contraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getRUC() {
        return RUC;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getCorreoContato() {
        return correoContato;
    }

    public void setCorreoContato(String correoContato) {
        this.correoContato = correoContato;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Farmacia{" +
                "id=" + id +
                ", RUC=" + RUC +
                ", nombreEstablecimiento='" + nombreEstablecimiento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correoContato='" + correoContato + '\'' +
                ", telefonoContacto=" + telefonoContacto +
                '}';
    }
}
