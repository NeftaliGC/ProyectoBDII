/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoDB.backend.objetos.inventario;

/**
 *
 * @author Webotes
 */
public interface InventarioStr {
    String NOMBRE_TABLA = "INVENTARIO";
    String NOMBRES_COLUMNAS[] = {
        "Id_inventario",
        "Cantidad_disponible",
        "Cantidad_minima",
        "Cantidad_limite"};
    
    String TIPOS_COLUMNAS[] = {
        "VARCHAR(10)",
        "NUMERIC(10)",
        "NUMERIC(10)",
        "NUMERIC(10)"};
}
