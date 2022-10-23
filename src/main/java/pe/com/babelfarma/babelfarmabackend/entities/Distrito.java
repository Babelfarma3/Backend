package pe.com.babelfarma.babelfarmabackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreDistrito;

    @OneToMany(mappedBy="distrito")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "distrito")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Farmacia> farmacias;

    public Distrito() {
    }

    public Distrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
}
