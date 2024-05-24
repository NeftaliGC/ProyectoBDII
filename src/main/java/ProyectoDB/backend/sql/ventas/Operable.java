/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoDB.backend.sql.ventas;

import java.util.List;

/**
 *
 * @author jft314
 * @param <T> Es el tipo de dato de la tabla
 * @param <G> Es el objeto que sera insertado o usado para localizar un conjunto
 */
public interface Operable<T, G> {

    /**
     *
     * @param param Es el objeto a insertar
     * @return
     */
    T alta(T param);

    /**
     *
     * @param param Es el objeto usado para localizar el objeto a eliminar
     * @return El objeto eliminado
     */
    G baja(G param);

    /**
     *
     * @param param Es el objeto usado para localizar el objeto a modificar
     * @return El objeto modificado
     */
    T modifica(G param);

    /**
     *
     * @param param Es el objeto usado para localizar el objeto a consultar
     * @return el objeto que cumple el criterio
     */
    T consulta(G param);

    /**
     *
     * @return lista de todos los registros almacenados
     */
    List<T> reporte();

}
