package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private double precioUnit;
    private double precioTotal;

    @OneToOne
    @JoinColumn(name="id_venta", nullable=false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;

    public DetalleVenta(){
    }
    public DetalleVenta(int cantidad, double precioUnit, double precioTotal) {
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}