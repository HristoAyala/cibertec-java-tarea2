package edu.cibertec.tareacap3.dao.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "factura")
public class FacturaEntity {

    @Id
    private String numero;

    private String cliente;
    private Double monto;
    private String fecha;
    private String moneda;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaDetalleEntity> detalles;

    public FacturaEntity() {
    }

    public FacturaEntity(String numero, String cliente, Double monto, String fecha, String moneda, List<FacturaDetalleEntity> detalles) {
        this.numero = numero;
        this.cliente = cliente;
        this.monto = monto;
        this.fecha = fecha;
        this.moneda = moneda;
        this.detalles = detalles;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public List<FacturaDetalleEntity> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalleEntity> detalles) {
        this.detalles = detalles;
    }
}

