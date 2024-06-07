package ProyectoDB.frontend.Controlador;
import Vista.InicioSesion;
import Modelo.connectionData;
import Vista.MenuFarmacia;

public class ControladorVista {
    public MenuFarmacia menuFarm;
    public InicioSesion inSesion;
    public connectionData conData;
    //UsuarioDao usDao;
    
    public ControladorVista() {
        menuFarm = new MenuFarmacia();
        inSesion = new InicioSesion();
    }
    
    public void iniciar(){
        inSesion.setVisible(true);
    }
    
    public boolean validate(String ip, String db,String schema, String password){
        conData = new connectionData();
        boolean val = true;
        conData.setIp(ip);
        conData.setDb(db);
        conData.setSchema(schema);
        conData.setPassword(password);
        if(val){
            inSesion.setVisible(false);
            menuFarm.setVisible(true);
        }
        return val;
    }
    
    public void returnStart(){
        menuFarm.setVisible(false);
        inSesion.setVisible(true);
    }
}