import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase Interfaz que extiende de JFrame e implementa ActionListener. 
 * Se encarga de generar la Interfaz que usaremos para implementar los métodos
 * de control usados para la Validación de la aplicación.
 *
 * @author Odei
 * @version 20.04.2016
 */
public class Interfaz extends JFrame implements ActionListener {
    /**
     * Variable usada para almacenar el Email del Usuario a Validar.
     */
    protected static JTextField tfEmail;
    
    /**
     * Variable usada para almacenar el Nombre del Usuario a Validar.
     */
    protected static JTextField tfNombre;
    
    /**
     * Variable usada para almacenar los Apellidos del Usuario a Validar.
     */
    protected static JTextField tfApellidos;
       
    /**
     * Variable usada para almacenar el Teléfono del Usuario a Validar.
     */
    protected static JTextField tfTelefono;
    
    /**
     * Variable usada para almacenar la Fecha de Nacimie. del Usuario a Validar.
     */
    protected static JTextField tfNacimiento;
    
    /**
     * Variable usada para almacenar el Código Postal del Usuario a Validar.
     */
    protected static JTextField tfCP;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Email.
     */
    protected static JLabel tfResulEmail;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Nombre.
     */
    protected static JLabel tfResulNombre;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Apellidos.
     */
    protected static JLabel tfResulApellidos;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Teléfono.
     */
    protected static JLabel tfResulTelefono;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Nacimiento.
     */
    protected static JLabel tfResulNacimiento;
    
    /**
     * Variable usada para mostrar el Resultado de la Validación del Cod.Postal.
     */
    protected static JLabel tfResulCP;
        
    /**
     * Variable botón usada para Validar los datos introducidos por el Usuario.
     */
    protected JButton btnValidar;
        
    /**
     * Constructor de la Interfaz Gráfica implementada para la Validación.
     * Genera e inicializa la Interfaz y los elementos utilizados
     * para visualizar de forma interactiva la ejecución de la Validación.
     * 
     * @throws java.io.IOException Posible Excepción producida al cargar las
     * imágenes de los botones usados para mostrar la Información de Ayuda
     */
    public Interfaz() throws IOException {
        JPanel panel = new JPanel(null);                                        // Creamos un panel para dibujar la interfaz gráfica
        JLabel lbEmail = new JLabel("Email:");                                  // Agregamos etiquetas, botones, y demás elementos a la Interfaz
        JLabel lbNombre = new JLabel("Nombre:");
        JLabel lbApellidos = new JLabel("Apellidos:");
        JLabel lbTelefono = new JLabel("Teléfono:");
        JLabel lbNacimiento = new JLabel("F. Nacimiento:");
        JLabel lbCP = new JLabel("C.P.:");
        JButton btnEmail = new JButton("");
        JButton btnNombre = new JButton("");
        JButton btnApellidos = new JButton("");
        JButton btnTelefono = new JButton("");
        JButton btnNacimiento = new JButton("");
        JButton btnCP = new JButton("");
        btnEmail.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));                           // Ponemos a los botones una imágen de fondo
        btnNombre.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));
        btnApellidos.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));
        btnTelefono.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));
        btnNacimiento.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));
        btnCP.setIcon(new ImageIcon(ImageIO.read(getClass()
                .getResource("recursos/info.png"))));
        tfEmail = new JTextField("");
        tfNombre = new JTextField("");
        tfApellidos = new JTextField("");
        tfTelefono = new JTextField("");
        tfNacimiento = new JTextField("");
        tfCP = new JTextField("");
        tfResulEmail = new JLabel("");
        tfResulNombre = new JLabel("");
        tfResulApellidos = new JLabel("");
        tfResulTelefono = new JLabel("");
        tfResulNacimiento = new JLabel("");
        tfResulCP = new JLabel("");
        btnValidar = new JButton("Validar");
        panel.add(lbEmail).setBounds(45, 25, 80, 20);
        panel.add(lbNombre).setBounds(45, 55, 80, 20);
        panel.add(lbApellidos).setBounds(45, 85, 80, 20);
        panel.add(lbTelefono).setBounds(45, 115, 80, 20);
        panel.add(lbNacimiento).setBounds(45, 145, 80, 20);
        panel.add(lbCP).setBounds(45, 175, 80, 20);
        panel.add(tfEmail).setBounds(135, 25, 115, 20);
        panel.add(tfNombre).setBounds(135, 55, 115, 20);
        panel.add(tfApellidos).setBounds(135, 85, 115, 20);
        panel.add(tfTelefono).setBounds(135, 115, 115, 20);
        panel.add(tfNacimiento).setBounds(135, 145, 115, 20);
        panel.add(tfCP).setBounds(135, 175, 115, 20);
        panel.add(tfResulEmail).setBounds(250, 10, 50, 50);
        panel.add(tfResulNombre).setBounds(250, 40, 50, 50);
        panel.add(tfResulApellidos).setBounds(250, 70, 50, 50);
        panel.add(tfResulTelefono).setBounds(250, 100, 50, 50);
        panel.add(tfResulNacimiento).setBounds(250, 130, 50, 50);
        panel.add(tfResulCP).setBounds(250, 160, 50, 50);
        panel.add(btnValidar).setBounds(45, 210, 205, 35);
        panel.add(btnEmail).setBounds(20, 25, 20, 20);
        panel.add(btnNombre).setBounds(20, 55, 20, 20);
        panel.add(btnApellidos).setBounds(20, 85, 20, 20);
        panel.add(btnTelefono).setBounds(20, 115, 20, 20);
        panel.add(btnNacimiento).setBounds(20, 145, 20, 20);
        panel.add(btnCP).setBounds(20, 175, 20, 20);
        
        btnValidar.addActionListener((ActionListener) this);
        btnEmail.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "Email");                                           // Añadimos un escuchador para capturar la pulsación de los botones
        });
        btnNombre.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "Nombre");
        });
        btnApellidos.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "Apellidos");
        });
        btnTelefono.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "Teléfono");
        });
        btnNacimiento.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "Nacimiento");
        });
        btnCP.addActionListener((ActionEvent evt) -> {
            lanzarInfo(evt, "CP");
        });
        
        JFrame frame = new JFrame("Formulario de Validación");                  // Creamos JFrame y le ponemos título
        frame.add(panel);                                                       // agregando el panel previamente creado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
                Interfaz.class.getResource("recursos/client.png")));            // Le ponemos una imágen de icono a la ventana
        frame.setSize(300, 295);                                                // y le asignamos tamaño y demás parámetros
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
 
   /**
     * Creamos un escuchador de eventos para capturar las opciones
     * utilizadas durante la ejecución de la Interfaz.
     * 
     * @param evt ActionEvent: evento lanzado por el Jugador
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if("Validar".equals(evt.getActionCommand())) {                          // Si pulsamos el botón Validar
            Validacion.validar();                                               // procesamos la validación llamando al método destinado para ello
        }
    }
    
    /**
     * Método usado para activar la visualización de la imágen usada para
     * mostrar errores o avisos al intentar acceder al Servidor.
     * 
     * @param lbl JLabel: variable que contiene el elemento a cambiar
     * @param nombre String: variable usada para almacenar el aviso a mostrar
     */
    protected static void cambiarImagen(JLabel lbl, String nombre) {
        lbl.setIcon(new ImageIcon(
            Interfaz.class.getResource("recursos/"+nombre+".png")));            // Asignamos una imágen a un elemento label concreto
    }
    
    /**
     * Método usado capturar el evento producido al pulsar el Botón de Info.
     * Lanza una ventana con Información relacionada con el botón pulsado.
     * 
     * @param evt ActionEvenot: evento lanzado por el Usuario
     * @param tipo String: nombre de la Información a mostrar
     */
    protected final void lanzarInfo(ActionEvent evt, String tipo) {
        String msj = "";                                                        // Creamos cadena que almacenará el mensaje a mostrar
        switch(tipo) {
            case "Email": 
                msj = "Formato: usuario@servidor.dominio\n\nSe validarán cadenas"
                    + " de caracteres donde usuario\ncontenga letras, números o"
                    + " los caracteres - _ . siendo\nel primer carácter una letra "
                    + "minúscula y el último un @  \nservidor será otra cadena de"
                    + " caracteres formada\npor letras y números y el último un "
                    + ". y dominio otra\ncadena que tendrá como máximo de 3 "
                    + "caracteres.\n\n";
            break;  
            case "Nombre":                                                      // Dependiendo de la cadena recibida asignamos un mensaje u otro
                msj = "Formato: nombre1 *nombre2\n\nSe validarán cadenas de "
                    + "caracteres con  \nespacios y una longitud entre 2 y 25.\n\n";
            break;   
            case "Apellidos":
                msj = "Formato: apellido1 *apellido2\n\nSe validarán cadenas de "
                    + "caracteres con  \nespacios y una longitud entre 2 y 25.\n\n";
            break;   
            case "Teléfono":
                msj = "Formato: 999/999/999\n\nSe validarán 3 dígitos del 0 al 9"
                    + " seguidos de /  \n3 dígitos más del 0 al 9 también"
                    + " seguidos de /  \n y 3 dígitos más del 0 al 9.\n\n";
            break;   
            case "Nacimiento":
                msj = "Formato: dd/mm/yy\n\nSe validarán 2 dígitos del 0 al 9 "
                    + "seguidos de /  \n2 dígitos del 0 al 9 también "
                    + "seguidos de de /  \ny 2 dígitos más del 0 al 9.\n\n";
            break;   
            case "CP":
                msj = "Formato: 99999\n\nSe validarán 5 dígitos del 0 al 9.\n\n";
            break;   
        }
        JOptionPane.showMessageDialog(null, msj, " Validación de " + tipo, 1);  // Mostramos mensaje en una ventana de dialogo
    }
}