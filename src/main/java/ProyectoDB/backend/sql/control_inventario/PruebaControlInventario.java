/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.control_inventario;

import ProyectoDB.DBConnection;
import ProyectoDB.backend.objetos.control_inventario.ControlInventario;
import ProyectoDB.backend.sql.ventas.SQLVenta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jft314
 */
public class PruebaControlInventario {

    public static void main(String[] args) {
        int opc = 2;

        try {
            DBConnection dbc = new DBConnection("localhost", "farma", "5432", "postgres", "8133pqalO");
            Connection connection = dbc.getConnection();
            SQLControlInventario control = new SQLControlInventario(connection);

            switch (opc) {
                case 1:

                    ControlInventario c = new ControlInventario(Timestamp.valueOf(LocalDateTime.now()), 88, "PROD008", "INV006");
                    control.alta(c);
                    break;
                case 2:
                    String c1 = control.bajaId("PROD004", "INV010");
                    System.out.println(c1);
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PruebaControlInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
