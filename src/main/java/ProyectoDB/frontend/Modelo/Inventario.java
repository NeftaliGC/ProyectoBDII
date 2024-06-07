package Modelo;

public class Inventario {
    private String id_inventario;
    private double cantidadDis;
    private double cantidadMin;
    private double cantidadLim;

    public Inventario() {
    }

    public Inventario(String id_inventario, double cantidadDis, double cantidadMin, double cantidadLim) {
        this.id_inventario = id_inventario;
        this.cantidadDis = cantidadDis;
        this.cantidadMin = cantidadMin;
        this.cantidadLim = cantidadLim;
    }

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    public double getCantidadDis() {
        return cantidadDis;
    }

    public void setCantidadDis(double cantidadDis) {
        this.cantidadDis = cantidadDis;
    }

    public double getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(double cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public double getCantidadLim() {
        return cantidadLim;
    }

    public void setCantidadLim(double cantidadLim) {
        this.cantidadLim = cantidadLim;
    }
    
    

}