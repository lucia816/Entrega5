import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class generadordecontraseña extends JFrame implements ActionListener {
    Random rnd = new Random();
    private JButton boton1;
    private JTextField generado;
    private JSlider slider;
    private JLabel label;
    private int num1 = 100;
    private  int num2 = 122;
    int numAleatorio = (int) Math.floor(Math.random() * (10));
    char letraaleatorio = (char) Math.floor(Math.random() * (num2 - num1) + num1);
    String[] simbolos = {"!","·","$","%","&","/","(",")","=","?","¿","@","#","*","]","}","[","{"};
    String []mayusculas = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String mayusculaaleatoria = mayusculas[rnd.nextInt(mayusculas.length) ];
    String simboloaleatorio = simbolos[rnd.nextInt(simbolos.length) ];
    JCheckBox checkboxl = new JCheckBox("Letras");
    JCheckBox checkBoxn = new JCheckBox("Numeros");
    JCheckBox checkBoxM = new JCheckBox("Mayusculas");
    JCheckBox checkBoxs = new JCheckBox("Simbolos");
    int salir = 1;


    generadordecontraseña(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       setLayout(new FlowLayout());

        JPanel p1= new JPanel();

        p1.setLayout(new GridLayout(4,4,4,4));
        JLabel contraseña= new JLabel("Contraseña generada: ");
        p1.add(contraseña);
        generado =new JTextField("");
        generado.setBounds(300,300,300,300);
        generado.setBackground(Color.ORANGE);
        p1.add(generado);


        p1.add(slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(5);
        slider.setPaintLabels(true);



        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(10,10,5,5));

        p2.add(checkboxl);
        p2.add(checkBoxn);
        p2.add(checkBoxM);
        p2.add(checkBoxs);
        p2.add(p1,BorderLayout.SOUTH);

        boton1 = new JButton("Generar contraseña");
        p1.add(boton1);

        boton1.addActionListener(this);

        System.out.println(numAleatorio);

        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.WEST);
        setSize(600,600);
        setVisible(true);
    }




    public static void main(String[] args) {
      generadordecontraseña generadordecontraseña = new generadordecontraseña();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int posicionslider = slider.getValue();
        System.out.println(posicionslider);


        if(checkBoxn.isSelected() && checkboxl.isSelected() && checkBoxs.isSelected() && checkBoxM.isSelected()) {
            generado.setText((simboloaleatorio + letraaleatorio + numAleatorio + mayusculaaleatoria));
        }

        if(checkBoxn.isSelected()  && checkBoxs.isSelected()) {
            generado.setText(simboloaleatorio+ numAleatorio );
        }
        if (checkBoxn.isSelected() && checkboxl.isSelected()){
            while (salir != posicionslider) {
                generado.setText(String.valueOf(letraaleatorio) + numAleatorio);

            }
        }
        if (checkBoxn.isSelected() && checkBoxM.isSelected() ){
            generado.setText(String.valueOf(numAleatorio )+ mayusculaaleatoria);
        }
        if(checkboxl.isSelected() && checkBoxs.isSelected()){
            generado.setText(String.valueOf(letraaleatorio)+ simbolos);
        }
        if (checkboxl.isSelected() && checkBoxM.isSelected()){
            generado.setText(String.valueOf(letraaleatorio)+ mayusculaaleatoria);
        }
        if (checkBoxM.isSelected() && checkBoxs.isSelected()) {
            String[] clave = {"!","·","$","%","&","/","(",")","=","?","¿","@","#","*","]","}","[","{","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            System.out.println(clave[20]);


          while (salir != 20){

                   String i = clave[(int) Math.floor(rnd.nextInt(44))];
                   System.out.println(i);

              salir++;
        }
}

        }
        /*if(checkBoxs.isSelected()){
            generado.setText(String.valueOf(simbolos));
        }
        if(checkBoxn.isSelected()){
            generado.setText(String.valueOf(numAleatorio));
        }
        if(checkboxl.isSelected()){
            generado.setText(String.valueOf(letraaleatorio));
        }
        if (checkBoxM.isSelected()){
            generado.setText("hola");
        }*/
    }
