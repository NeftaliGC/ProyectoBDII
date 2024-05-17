/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.sql.ventas;

import ProyectoDB.objetos.venta.Venta;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jft314
 */
public class SQLVenta implements Operable<Venta, String> {

    private final Connection connection;

    public SQLVenta(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <Venta> Venta alta(Venta param) {
        throw new UnsupportedOperationException("Not supported yet."); // Stringenerated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <Venta, String> Venta baja(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Ventaemplates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <Venta, String> Venta modifica(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <Venta, String> List<Venta> consulta(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}
