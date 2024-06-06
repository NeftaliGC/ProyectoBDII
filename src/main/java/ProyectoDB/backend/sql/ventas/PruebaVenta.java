/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.ventas;

import ProyectoDB.DBConnection;
import ProyectoDB.backend.objetos.venta.Venta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jft314
 */
public class PruebaVenta {

    public static void main(String[] args) {
        try {
            pruebaFunciones();
        } catch (SQLException ex) {
            Logger.getLogger(PruebaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void pruebaFunciones() throws SQLException {
        int op = 2;
        DBConnection dbc = new DBConnection("localhost", "farma", "5432", "postgres", "8133pqalO");
        Connection connection = dbc.getConnection();
        SQLVenta sqlVenta = new SQLVenta(connection);

        switch (op) {
            case 1:

                List<Venta> lista = sqlVenta.reporte();

                for (Venta venta1 : lista) {
                    System.out.println(venta1.toString());
                }
                break;
            case 2:
                long l = Long.parseLong("6740259002");
                Venta v = sqlVenta.alta(new Venta("dasdas", 6, 25.58, true, "PROD002", "BADM491122OO7", l));
                System.out.println(v);
                break;

        }
    }
}




