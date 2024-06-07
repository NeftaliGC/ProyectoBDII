package main.java.ProyectoDB.frontend.Controlador;

import ProyectoDB.frontend.Modelo.VentasData;
import main.java.ProyectoDB.frontend.Modelo.VentasDao;
import main.java.ProyectoDB.frontend.Ventas;
import javax.swing.table.DefaultTableModel;

public class ControladorDatos {
    VentasData vData;
    VentasDao vDAO;
    Ventas vtas;
    
    public DefaultTableModel modelo = new DefaultTableModel();

    public ControladorDatos() {
        vData = new VentasData();
        vDAO = new VentasDao();
    }
    
}
