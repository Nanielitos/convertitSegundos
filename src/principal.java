import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class principal extends JFrame {

    //Declarar variables del panel
    private JLabel ingresarDat;
    private JTextField ingresarDat1;
    private JButton convertir;

    public principal (){
        super("Convertidor de segundos");
        setLayout(new GridBagLayout());
        GridBagConstraints restricciones = new GridBagConstraints();
        Container contenedorPrincipal = this.getContentPane();
        contenedorPrincipal.setLayout(new GridBagLayout());
        contenedorPrincipal.setBackground(Color.black);

        //Creación del panel
        TitledBorder border = new TitledBorder(" Ingresar datos ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        JPanel segundosPanel = new JPanel();
        segundosPanel.setBorder(border);
        segundosPanel.setLayout(new GridBagLayout());

        //Contenido del panel
        ingresarDat = new JLabel("Ingrese los segundos");
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridheight = 1;
        restricciones.gridwidth = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.anchor = GridBagConstraints.WEST;
        restricciones.insets.set(1,0,5,0);
        restricciones.fill = GridBagConstraints.NONE;
        segundosPanel.add(ingresarDat, restricciones);

        ingresarDat1 = new JTextField("Escriba aquí");
        restricciones.gridx = 1;
        restricciones.gridy = 0;
        restricciones.gridheight = 1;
        restricciones.gridwidth = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.ipadx = 40;
        restricciones.ipady = 0;
        restricciones.anchor = GridBagConstraints.EAST;
        restricciones.insets.set(1,0,5,0);
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        segundosPanel.add(ingresarDat1, restricciones);

        convertir = new JButton("Convertir");
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridheight = 1;
        restricciones.gridwidth = 1;
        restricciones.weightx = 0;
        restricciones.weighty = 0;
        restricciones.anchor = GridBagConstraints.WEST;
        restricciones.insets.set(1,0,0,0);
        restricciones.fill = GridBagConstraints.NONE;
        segundosPanel.add(convertir, restricciones);

        //Medidas del panel
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridheight = 2;
        restricciones.gridwidth = 3;
        restricciones.weightx = 1;
        restricciones.weighty = 1;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.anchor = GridBagConstraints.NORTH;
        restricciones.insets.set(0,0,0,0);
        contenedorPrincipal.add(segundosPanel, restricciones);

        //Creación de objetos oyentes
        AccionBoton oyenteConvertir = new AccionBoton();
        //Vincular los oyentes a los objetos que generan el evento
        convertir.addActionListener(oyenteConvertir);



    }

    public static void main (String[] args){
        principal ventana = new principal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.pack();
    }
    //Clase interna
    class AccionBoton implements ActionListener {
    int segundos, resultados;

     //Ventana emergente con el resltado de la converción
        @Override
        public void actionPerformed(ActionEvent e) {
            if ((JButton) e.getSource() == convertir) {

                if (segundos < 1000000000) {
                    JOptionPane.showMessageDialog(null,
                            "El resultado es: " + resultados,
                            "Resultado", JOptionPane.INFORMATION_MESSAGE);

                    //procedimiento para convertir los segundos
                    segundos = Integer.parseInt(ingresarDat1.getText());
                    }

                    //Mostrar error si ingresa más de un millón
                else {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese una cantidad inferior a un millón",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

            }
        }
    }
}
