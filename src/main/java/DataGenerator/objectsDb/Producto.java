/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.objectsDb;

/**
 *
 * @author jesus
 */
public class Producto {

    private final String idProducto;
    private final String nombreProducto;
    private final String descripcion;
    private final double precioUnitario;
    private final String idCategoria;
    private final String idLote;
    private final String idFarmacia;

    public Producto(
            String idProducto,
            String nombreProducto,
            String descripcion,
            double precioUnitario,
            String idCategoria,
            String idLote,
            String idFarmacia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.idCategoria = idCategoria;
        this.idLote = idLote;
        this.idFarmacia = idFarmacia;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public String getIdLote() {
        return idLote;
    }

    public String getIdFarmacia() {
        return idFarmacia;
    }

}
