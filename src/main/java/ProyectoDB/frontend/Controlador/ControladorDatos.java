package Controlador;
import java.math.BigDecimal;
import Modelo.Inventario;
import Modelo.InventarioDao;
import Modelo.VentasData;
import Modelo.VentasDao;
import Vista.Ventas;
import java.util.List;
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
