package edu.cibertec.tareacap3.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "facturadetalle")
public class FacturaDetalleEntity {

    @Id
    private int idDetalle;
    private int cantidad;
    private String producto;
    private Double precioUnitario;
    private Double parcial;

    @ManyToOne
    @JoinColumn(name = "numeroFactura")
    private FacturaEntity factura;

    public FacturaDetalleEntity() {
    }

    public FacturaDetalleEntity(int idDetalle, int cantidad, String producto, Double precioUnitario, Double parcial, FacturaEntity factura) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.parcial = parcial;
        this.factura = factura;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getParcial() {
        return parcial;
    }

    public void setParcial(Double parcial) {
        this.parcial = parcial;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
}
