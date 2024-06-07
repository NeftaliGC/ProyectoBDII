package Modelo;

import java.math.BigDecimal;

public class VentasData {
    String idVenta;
    BigDecimal cantVendida;
    BigDecimal totalVenta;
    boolean Receta; 
    String idProducto;
    String rfc;
    BigDecimal idTicket;

    public VentasData() {
    }

    public VentasData(String idVenta, BigDecimal cantVendida, BigDecimal totalVenta, boolean Receta, String idProducto, String rfc, BigDecimal idTicket) {
        this.idVenta = idVenta;
        this.cantVendida = cantVendida;
        this.totalVenta = totalVenta;
        this.Receta = Receta;
        this.idProducto = idProducto;
        this.rfc = rfc;
        this.idTicket = idTicket;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public BigDecimal getCantVendida() {
        return cantVendida;
    }

    public void setCantVendida(BigDecimal cantVendida) {
        this.cantVendida = cantVendida;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public boolean isReceta() {
        return Receta;
    }

    public void setReceta(boolean Receta) {
        this.Receta = Receta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public BigDecimal getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(BigDecimal idTicket) {
        this.idTicket = idTicket;
    }
}
