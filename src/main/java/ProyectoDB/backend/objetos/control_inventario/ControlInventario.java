/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.objetos.control_inventario;

import java.sql.Timestamp;

/**
 *
 * @author jft314
 */
public class ControlInventario {

    private Timestamp fechaRegistro;
    private int cantidadVendida;
    private String id_producto;
    private String id_inventario;

    public ControlInventario(
            Timestamp fechaRegistro,
            int cantidadVendida,
            String id_producto,
            String id_inventario) {
        this.fechaRegistro = fechaRegistro;
        this.cantidadVendida = cantidadVendida;
        this.id_producto = id_producto;
        this.id_inventario = id_inventario;
    }

    @Override
    public String toString() {

        return String.format("'%s', %d, '%s', '%s'",
                fechaRegistro,
                cantidadVendida,
                id_producto,
                id_inventario);
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

}
