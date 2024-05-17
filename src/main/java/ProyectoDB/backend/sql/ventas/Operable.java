/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoDB.sql.ventas;

import java.util.List;

/**
 *
 * @author jft314
 * @param <T>
 */
public interface Operable<T, G> {

    <T> T alta(T param);

    <T, G> T baja(G param);

    <T, G> T modifica(G param);

    <T, G> List<T> consulta(G param);

}
