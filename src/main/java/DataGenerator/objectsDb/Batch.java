/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.objectsDb;

import java.util.Date;

/**
 *
 * @author jesus
 */
public class Batch {

    private final String idLote;
    private final int cantidadStock;
    private final Date fechaFabricacion;
    private final Date fechaCaducidad;
    private final Date fechaEntrega;
    private final double coste;
    private final double iva;
    private final double totalLote;
    private final int idProveedor;

    public Batch(
            String idLote,
            int cantidadStock,
            Date fechaFabricacion,
            Date fechaCaducidad,
            Date fechaEntrega,
            double coste,
            double iva,
            double totalLote,
            int idProveedor) {

        this.idLote = idLote;
        this.cantidadStock = cantidadStock;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaEntrega = fechaEntrega;
        this.coste = coste;
        this.iva = iva;
        this.totalLote = totalLote;
        this.idProveedor = idProveedor;
    }

    public String getIdLote() {
        return idLote;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public double getCoste() {
        return coste;
    }

    public double getIva() {
        return iva;
    }

    public double getTotalLote() {
        return totalLote;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

}
