package pe.com.babelfarma.babelfarmabackend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_farmacia", nullable=false)
    private Farmacia farmacia;

    @OneToOne(mappedBy = "venta")
    private Envio envio;

    @OneToOne(mappedBy = "venta")
    private DetalleVenta detalleVenta;

    public Venta(){
    }

    public Venta(Date fecha, Cliente cliente, Farmacia farmacia) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.farmacia = farmacia;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public Long getFarmaciaId(){
        return farmacia.getId();
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Envio getEnvio() {
        return envio;
    }

    public Long getEnvioId(){
        return envio.getId();
    }
    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
