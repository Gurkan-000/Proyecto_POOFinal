
package Util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author RODRIGO
 */
public class FechasHora {
    
    private static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    
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
