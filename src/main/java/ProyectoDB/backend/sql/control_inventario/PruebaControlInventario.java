/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.control_inventario;

import ProyectoDB.DBConnection;
import ProyectoDB.backend.objetos.control_inventario.ControlInventario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jft314
 */
public class PruebaControlInventario {

    public static void main(String[] args) {
        int opc = 4;

        try {
            DBConnection dbc = new DBConnection("localhost", "farma", "farma", "5432", "postgres", "8133pqalO");
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

                case 3:
                    List<ControlInventario> l = control.reporte();

                    for (ControlInventario controlInventario : l) {
                        System.out.println(controlInventario);
                    }
                    break;

                case 4:
                    ControlInventario c2 = new ControlInventario(Timestamp.valueOf("2078-04-04 09:55:55.0"), 9874, "PROD006", "INV004");

                    control.modifica("PROD006", "INV004", c2);
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PruebaControlInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
