/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.objetos.venta;

/**
 *
 * @author jft314
 */
public class Venta implements VentaInterface {

    private String idVenta;
    private int cantidadVendida;
    private double totalVenta;
    private boolean recetaMedica;
    private String idProducto;
    private int rfcCliente;
    private int idTicket;

    public Venta(
            String idVenta,
            int cantidadVendida,
            double totalVenta,
            boolean recetaMedica,
            String idProducto,
            int rfcCliente,
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
        stringBuilder.append(String.format("'%s', ", idVenta));
        stringBuilder.append(String.format("%s, ", cantidadVendida));
        stringBuilder.append(String.format("%s, ", totalVenta));
        stringBuilder.append(String.format("%s, ", recetaMedica));
        stringBuilder.append(String.format("'%s', ", idProducto));
        stringBuilder.append(String.format("'%s', ", rfcCliente));
        stringBuilder.append(String.format("'%s'", idTicket));

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

    public String getIdProducto() {
        return idProducto;
    }

    public int getRfcCliente() {
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

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setRfcCliente(int rfcCliente) {
        this.rfcCliente = rfcCliente;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public static String getNombreColumnas() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String nombre : NOMBRES_COLUMNAS) {

            stringBuilder.append(nombre).append(", ");
        }
        stringBuilder.delete(
                stringBuilder.length() - 3, stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
