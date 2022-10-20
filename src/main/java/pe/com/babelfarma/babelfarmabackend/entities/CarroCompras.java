package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carros_compras")
public class CarroCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;



    public CarroCompras(int cantidad) {
        this.cantidad = cantidad;
    }

    public CarroCompras(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
