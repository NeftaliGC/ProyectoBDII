/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author jft314
 */
public class JlabelPersonalizado extends JLabel {

    public JlabelPersonalizado(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        configuration();

    }

    public JlabelPersonalizado(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        configuration();

    }

    public JlabelPersonalizado(String text) {
        super(text);
        configuration();

    }

    public JlabelPersonalizado(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        configuration();

    }

    public JlabelPersonalizado(Icon image) {
        super(image);
        configuration();

    }

    public JlabelPersonalizado() {
        configuration();
    }

    public void configuration() {
        setForeground(new Color(30, 144, 255));
        setFont(new Font("Tahoma", Font.PLAIN, 12));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
