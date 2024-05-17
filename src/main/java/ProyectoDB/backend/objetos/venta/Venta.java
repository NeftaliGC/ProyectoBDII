/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.objetos.venta;

/**
 *
 * @author jft314
 */
public class Venta implements Vendible {

    private String idVenta;
    private int cantidadVendida;
    private double totalVenta;
    private boolean recetaMedica;
    private int idProducto;
    private String rfcCliente;
    private int idTicket;

    public Venta(
            String idVenta,
            int cantidadVendida,
            double totalVenta,
            boolean recetaMedica,
            int idProducto,
            String rfcCliente,
            int idTicket) {

        this.idVenta = idVenta;
        this.cantidadVendida = cantidadVendida;
        this.totalVenta = totalVenta;
        this.recetaMedica = recetaMedica;
        this.idProducto = idProducto;
        this.rfcCliente = rfcCliente;
        this.idTicket = idTicket;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[0], NOMBRES_COLUMNAS[0], idVenta));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[1], NOMBRES_COLUMNAS[1], cantidadVendida));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[2], NOMBRES_COLUMNAS[2], totalVenta));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[3], NOMBRES_COLUMNAS[3], recetaMedica));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[4], NOMBRES_COLUMNAS[4], idProducto));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[5], NOMBRES_COLUMNAS[5], rfcCliente));
        stringBuilder.append(String.format("%s[%s]= %s\n", TIPOS_COLUMNAS[6], NOMBRES_COLUMNAS[6], idTicket));

        return stringBuilder.toString();
    }

    public String getIdVenta() {
        return idVenta;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public boolean isRecetaMedica() {
        return recetaMedica;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getRfcCliente() {
        return rfcCliente;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public void setRecetaMedica(boolean recetaMedica) {
        this.recetaMedica = recetaMedica;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setRfcCliente(String rfcCliente) {
        this.rfcCliente = rfcCliente;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

}
