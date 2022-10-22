package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;

@Entity
@Table(name="envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String encargado;
    private String direccionEnvio;

    @OneToOne (mappedBy = "envio")
    private Venta venta;

    public Envio(){
    }
    public Envio(String encargado, String direccionEnvio) {
        this.encargado = encargado;
        this.direccionEnvio = direccionEnvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
}