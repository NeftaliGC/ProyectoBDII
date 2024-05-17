/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoDB.objetos.venta;

/**
 *
 * @author jft314
 */
public interface Vendible {

    String NOMBRE_TABLA = "VENTA";
    String NOMBRES_COLUMNAS[] = {
        "Id_venta",
        "Cantidad_vendida",
        "Total_venta",
        "Receta_medicina",
        "Id_producto",
        "Rfc_cliente",
        "Id_ticket"};
    
    String TIPOS_COLUMNAS[] = {
        "VARCHAR(10)",
        "NUMERIC(3)",
        "NUMERIC(10, 2)",
        "BOOLEAN",
        "VARCHAR(10)",
        "VARCHAR(13)",
        "NUMERIC(10)"};
    
    
}
