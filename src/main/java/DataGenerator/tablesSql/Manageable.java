/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataGenerator.tablesSql;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface Manageable {
    
   <T> List<T> select()  throws SQLException;
}
