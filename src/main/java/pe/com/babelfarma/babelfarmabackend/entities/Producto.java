package pe.com.babelfarma.babelfarmabackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //pa q funcione
    private Categoria categoria;

    @ManyToMany(mappedBy = "productos")
    private List<Farmacia> farmacias = new ArrayList<>();

    public Producto(String nombre, int stock, double precio, String descripcion, Categoria categoria) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

}
