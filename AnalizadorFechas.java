import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author COLOQUE AQUI SU NOMBRE COMPLETO
 * @author COLOQUE AQUI SU MATRICULA
 */
public class AnalizadorFechas {
    private DateFormat formateadorCorto;
    private DateFormat formateadorLargo;
    private Locale region;
    
    public static void main(String[] args) {        
        AnalizadorFechas analyzer = new AnalizadorFechas();
        analyzer.procesaEntrada();
    }
    
    /**
     * Este metodo leer lineas de la entrada estandar (teclado)
     * y las procesa de acuerdo a lo siguiente:
     * La primer linea de entrada contiene dos valores separados por espacio:
     * a) Codigo que representa un idioma (estandar ISO 639)
     * b) Codigo que representa un pais (estandar ISO 3166)
     * Esta primer linea representa el formato en estilo
     * corto con el cual se aceptaran las fechas que se encuentren en 
     * las posteriores lineas (si es que de hecho la linea contiene 
     * una fecha)
     * Por cada linea leida no vacia a partir de la segunda imprime
     * en la salida estandar el resultado de llamar a la funcion
     * formateaFechaEn pasandole como argumento la linea leida o
     * el mensaje LINEA SIN FECHA VALIDA en caso que la linea
     * leida no haya tenido una fecha valida.
     * ASUMA QUE LA ENTRADA SIEMPRE SERA DADA CON LAS CARACTERISTICAS 
     * MENCIONADAS:
     * A) LA PRIMER LINEA CONSISTE DE CODIGO DE IDIOMA Y CODIGO DE PAIS
     * B) A PARTIR DE LA SEGUNDA LINEA EN ADELANTE LAS LINEAS PUDIERAN
     *    ESTAR VACIAS (EN CUYO CASO SE DESCARTA LA LINEA)
     *    O CONTENDRAN SOLO UNA FECHA EN FORMATO CORTO
     *    O CUALQUIER OTRO TEXTO.
     */
    private void procesaEntrada() {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
        try {
            // Leemos primera linea
            String linea=in.readLine();
            // La separamos en sus dos componentes
            String elems[]=linea.split(" ");
            // Con esos datos creamos un objeto Locale
            // y los formateadores de fecha
            region = new Locale(elems[0], elems[1]);
            formateadorCorto=DateFormat.getDateInstance(
                    DateFormat.SHORT, region);
            formateadorLargo=DateFormat.getDateInstance(
                    DateFormat.LONG, region);        
            // Leemos las restantes lineas
            linea=in.readLine();
            while (linea!=null) {  // Mientras haya otra linea mas
                // Imprimimos el resultado que devuelve formateaFechaCon
                try {
                    if (!linea.isEmpty()) {
                        System.out.println(formateaFechaEn(linea));
                    }
                }
                catch (ParseException ex) {
                    System.out.println("LINEA SIN FECHA VALIDA");
                }
                // y leemos la siguiente linea
                linea=in.readLine();
            }
            in.close(); // Cerramos el BufferedReader
        } catch (IOException eio) {  // En caso de excepcion
            System.out.println("Error al leer entrada.");
        }
    }

    /**
     * Este metodo debera regresar el resultado de convertir a 
     * formato largo (LONG), el contenido de la fecha contenida en 
     * el parametro recibido
     * @param linea linea que posiblemente contiene una fecha en estilo corto
     * @return String con la fecha correspondiente en estilo largo
     * @throws ParseException En caso de que la linea no contenga solo una fecha valida
     */
    public String formateaFechaEn(String linea)
     throws ParseException{
        return linea;
    }
}
