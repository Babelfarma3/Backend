package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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