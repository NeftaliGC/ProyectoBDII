/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.objectsDb;

/**
 *
 * @author jesus
 */
public class Category {

    private final String idCategoria;
    private final String name;
    private final int secuenciaCategoria;
    private final String description;

    public Category(
            String idCategoria,
            int secuenciaCategoria,
            String name,
            String description) {

        this.idCategoria = idCategoria;
        this.name = name;
        this.secuenciaCategoria = secuenciaCategoria;
        this.description = description;
    }

    public Category(
            String name,
            String description) {

        idCategoria = "";
        secuenciaCategoria = -1;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s - %d - %s - %s",
                idCategoria,
                secuenciaCategoria,
                name,
                description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public int getSecuenciaCategoria() {
        return secuenciaCategoria;
    }
    
    

}
