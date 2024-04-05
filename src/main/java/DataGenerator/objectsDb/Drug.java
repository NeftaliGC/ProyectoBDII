/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.objectsDb;

/**
 *
 * @author jesus
 */
public class Drug {

    private final String name;
    private final String aplicacion;
    private final String type;
    private final String description;

    public Drug(
            String name,
            String aplicacion,
            String type,
            String description) {

        this.name = name;
        this.aplicacion = aplicacion;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s",
                name,
                aplicacion,
                type,
                description);
    }

    public String getName() {
        return name;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

}
