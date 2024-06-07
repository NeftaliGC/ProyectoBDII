package ProyectoDB.frontend.Controlador;
import ProyectoDB.frontend.Modelo.VentasData;
import ProyectoDB.frontend.Modelo.VentasDao;
import Vista.Ventas;
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
