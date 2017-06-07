import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Clase Validación. 
 * Se encarga de generar los Procedimientos que usaremos para implementar 
 * los métodos de control usados para la Validación de la aplicación.
 *
 * @author Odei
 * @version 20.04.2016
 */
public class Validacion {
    /**
     * Variable Logger usada para capturar todos los eventos de los registros
     * de Seguridad producidos durante la ejecución de la aplicación.
     */
    protected static final Logger logger = Logger.getLogger("MyLog");
    
    /**
     * Variable de tipo cadena usada para almacenar la Ruta del equipo 
     * donde estará almacenado el fichero con los datos del Usuario.
     */
    protected static final String ruta = "src/recursos/";
    
    /**
     * Constructor de la Clase Validación.
     * Genera e inicializa los elementos utilizados para gestionar la
     * ejecución de la Validación del Usuario creando una Interfaz Gráfica.
     */
    public Validacion() {
        try {
            iniciarLogger();
            Interfaz interfaz = new Interfaz();                                 // Lanzamos una Instancia de la Interfaz Gráfica para el Usuario
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excepción {0}", e.toString());            // capturando cualquier posible eventualidad producida
        }
    }
    
    /**
     * Método usado para inicializar el Logger que usaremos en la Aplicación.
     * Crea e inicializa la variable Logger que utilizaremos durante la
     * ejecución del Programa para capturar los eventos producidos en el mismo.
     */
    protected static void iniciarLogger() {
        try {
            FileHandler fh = new FileHandler(ruta + "registro.log", true);      // Configuramos el logger y establecemos el formato
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);                                         // capturamos todos los eventos producidos
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.CONFIG,"Iniciada captura de Eventos Logger");      // Añadimos un mensaje inicial al log
        } catch (IOException | SecurityException e) {
            logger.log(Level.SEVERE, "Excepción {0}", e.toString());
        }
    }
    
   /**
     * Método usado para procesar la Validación del Usuario comprobando las
     * cadenas a validar e interactuando con los elementos de la Interfaz.
     */
    protected static void validar() {
        String[] regex =   {"^[a-z][\\w-_\\.]{1,}@([\\w-_]{1,}\\.)[\\w]{1,3}$",
                            "^[A-ZÑa-zñÁÉÍÓÚáéíóú ]{2,25}$", 
                            "^[A-ZÑa-zñÁÉÍÓÚáéíóú ]{2,25}$", 
                            "^\\d{3}/\\d{3}/\\d{3}$", 
                            "^\\d{2}/\\d{2}/\\d{2}$", 
                            "^\\d{5}$" };
        String[] cadenas = {Interfaz.tfEmail.getText(), 
                            Interfaz.tfNombre.getText(), 
                            Interfaz.tfApellidos.getText(), 
                            Interfaz.tfTelefono.getText(), 
                            Interfaz.tfNacimiento.getText(), 
                            Interfaz.tfCP.getText() };
        JLabel[] labels =  {Interfaz.tfResulEmail, 
                            Interfaz.tfResulNombre, 
                            Interfaz.tfResulApellidos, 
                            Interfaz.tfResulTelefono, 
                            Interfaz.tfResulNacimiento, 
                            Interfaz.tfResulCP };
        boolean sw = true;                                                      // Creamos variable para comprobar si existen errores
        for (int i = 0; i < cadenas.length; i++) {                              // Recorremos las cadenas a validar
            String img = "ok";
            if (cadenas[i].equals("")) {                                        // Si la variable esta vacía
                img = "vacio";                                                  // establecemos la imagen correspondiente
                sw = false;                                                     // y asignamos un error
            } else if (!Pattern.compile(regex[i]).matcher(cadenas[i]).find()) { // Si la variable no concuerda con la expresión regular
                img = "error";                                                  // establecemos la imagen correspondiente
                sw = false;                                                     // y asignamos un error
            }//logger.log(Level.INFO,"Validación {0} {1}",new Object[]{cadenas[i],img});
            Interfaz.cambiarImagen(labels[i], img);                             // mostramos un aviso en forma de imágen para el elemento a comprobar
        }
        
        if (sw) {                                                               // Si no existen errores lanzamos una ventana
            int aux = JOptionPane.showConfirmDialog(null,"Deseas exportar los "+
                "datos validados?","Validación Completada",JOptionPane.YES_NO_OPTION);
            if (aux == 0) {                                                     // Si decidmos exportar los datos creamos un fichero con los mismos
                JOptionPane.showMessageDialog(null, "Se procederá a crear el "+
                "fichero con tus\ndatos en la ruta:   "+ruta,"Exportación Completada",1);
                exportarDatos(cadenas);
                logger.log(Level.INFO, "Exportación Completada");
            } else {
                logger.log(Level.INFO, "No se desea Exportación");
            }
        }
    }
    
    /**
     * Método usado para guardar un fichero log en el Servidor.
     * Crea un fichero con la fecha de cierre del Servidor que contiene
     * todas las operaciones realizadas en el mismo durante su ejecución.
     * 
     * @param datos String[]: vector con datos validados a exportar
     */
    protected static void exportarDatos(String[] datos) {
        try {                                                                   // Creamos el fichero log
            BufferedWriter bw=new BufferedWriter(new FileWriter(ruta+"datos.txt"));
            for (String dato : datos) {                                         // y recorremos las cadenas a exportar
                bw.write(dato + "\n");                                          // escribiendo sus valores en el fichero
                bw.flush();
            }
        } catch (IOException e) { 
            logger.log(Level.SEVERE, "Excepción {0}", e.toString());
        }
    }
    
    /**
     * Método Principal de la Clase Validación.
     * Lanza una Instancia del Programa llamando al Constructor.
     * 
     * @param args String[]: argumentos de la línea de comandos
     */
    public static void main( String[] args ) {
        Validacion validacion = new Validacion();                               // Creamos una Instancia del Programa
    }
}