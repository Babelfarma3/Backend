package pe.com.babelfarma.babelfarmabackend.entities;

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

    @ManyToMany
            @JoinTable(name = "farmacias_productos",
                    joinColumns = @JoinColumn(name = "farmacia_id", referencedColumnName = "id", nullable = false),
                    inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id",nullable = false))
    List<Producto> productos = new ArrayList<>();

    public Farmacia() {
    }

    public Farmacia(int RUC, String nombreEstablecimiento, String direccion, String correoContato, int telefonoContacto) {
        this.RUC = RUC;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.direccion = direccion;
        this.correoContato = correoContato;
        this.telefonoContacto = telefonoContacto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
