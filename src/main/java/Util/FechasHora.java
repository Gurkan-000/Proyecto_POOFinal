
package Util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author RODRIGO
 */
public class FechasHora {
    

    
    public static String parseString(LocalDate fecha){
        
        return String.valueOf(fecha);
        
    }
    
    public static String parseString(LocalTime hora){
        
        return String.valueOf(hora);
        
    }
       
    public static String parseHora(String hora){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime ld = LocalTime.parse(hora);
        return ld.format(formato);
    }
     
}
