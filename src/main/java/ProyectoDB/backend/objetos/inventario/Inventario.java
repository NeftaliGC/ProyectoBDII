/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.objetos.inventario;

/**
 *
 * @author Webotes
 */
public class Inventario implements InventarioStr {

    private String idInventario;
    private int cantidadDisponible;
    private int cantidadMinima;
    private int cantidadLimite;

    public Inventario(
            String idInventario,
            int cantidadDisponible,
            int cantidadMinima,
            int cantidadLimite
    ) {
        this.idInventario = idInventario;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadMinima = cantidadMinima;
        this.cantidadLimite = cantidadLimite;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append(String.format("%s, ", idInventario));
        stringBuilder.append(String.format("%s, ", cantidadDisponible));
        stringBuilder.append(String.format("%s, ", cantidadMinima));
        stringBuilder.append(String.format("%s, ", cantidadLimite));
        return stringBuilder.toString();
    }

    public String getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(String idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadLimite() {
        return cantidadLimite;
    }

    public void setCantidadLimite(int cantidadLimite) {
        this.cantidadLimite = cantidadLimite;
    }
    
}
