import javax.swing.*;
import java.awt.event.*;//paquete para controlar los eventos
import java.awt.*;

public class Calculadora extends JFrame {

  JLabel Letrero, lblNom1, lblNom2, lblRes;
  JButton btnSumar, btnRestar, btnMultiplicar, btnDividir, btnSalir;
  JTextField txtNom1, txtNom2, txtRes;
  JPanel panel;
  private Object objTextField;
  
  public Calculadora() {
   initComponents();
  }
  
  private void initComponents() {
    setSize(400, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    txtNom1 = new JTextField(10);
    txtNom2 = new JTextField(10);
    txtRes = new JTextField(10);
    txtRes.setEditable(false);
    
    Letrero = new JLabel("CALCULADORA");
    lblNom1 = new JLabel("Numero 1: ");
    lblNom2 = new JLabel("\nNumero 2: ");
    
    btnSumar = new JButton("Suma");
    btnSumar.setMnemonic('S');
    btnRestar = new JButton("Resta");
    btnRestar.setMnemonic('R');
    btnMultiplicar = new JButton("Multiplicar");
    btnMultiplicar.setMnemonic('M');
    btnDividir = new JButton("Dividir");
    btnDividir.setMnemonic('D');
    btnSalir = new JButton("Salir");
    btnSalir.setMnemonic('S');
    
    btnSumar.addMouseListener(new Sumar());
    btnRestar.addMouseListener(new Restar());
    btnMultiplicar.addMouseListener(new Multiplicar());
    btnDividir.addMouseListener(new Dividir());
    btnSalir.addMouseListener(new MyListener());
    
    panel = new JPanel();
    panel.add(Letrero);
    panel.add(lblNom1);
    panel.add(txtNom1);
    panel.add(lblNom2);
    panel.add(txtNom2);
    panel.add(txtRes);
    panel.add(btnSumar);
    panel.add(btnRestar);
    panel.add(btnMultiplicar);
    panel.add(btnDividir);
    panel.add(btnSalir);
    
    setTitle("CALCULADORA BASICS_Mancilla Alcaraz Jaret Alan");
    setContentPane(panel);
    setVisible(true);
  }
  
  //Sumar
  private class Sumar extends MouseAdapter {
     float n1 = 0, n2 = 0, suma;
     
     public void mouseClicked(MouseEvent event) {
        String x1 = txtNom1.getText();
        n1 = Integer.parseInt(x1);
        String x2 = txtNom2.getText();
        n2 = Integer.parseInt(x2);
        try {
          suma = n1 + n2;
          txtRes.setText(String.valueOf(suma));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor no es correcto");
            txtNom1.setText(" ");
            txtNom1.requestFocus();
            txtNom2.setText(" ");
            txtNom2.requestFocus();
            txtRes.setText("0.00");
        }
     }
  }
  
  //Restar
  private class Restar extends MouseAdapter {
     float n1 = 0, n2 = 0, resta;
     
     public void mouseClicked(MouseEvent event) {
        String x1 = txtNom1.getText();
        n1 = Integer.parseInt(x1);
        String x2 = txtNom2.getText();
        n2 = Integer.parseInt(x2);
        try {
          resta = n1 - n2;
          txtRes.setText(String.valueOf(resta));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor no es correcto");
            txtNom1.setText(" ");
            txtNom1.requestFocus();
            txtNom2.setText(" ");
            txtNom2.requestFocus();
            txtRes.setText("0.00");
        }
     }
  }
  
  //Multiplicar
  private class Multiplicar extends MouseAdapter {
     float n1 = 0, n2 = 0, multiplicacion;
     
     public void mouseClicked(MouseEvent event) {
        String x1 = txtNom1.getText();
        n1 = Integer.parseInt(x1);
        String x2 = txtNom2.getText();
        n2 = Integer.parseInt(x2);
        try {
          multiplicacion = n1 * n2;
          txtRes.setText(String.valueOf(multiplicacion));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor no es correcto");
            txtNom1.setText(" ");
            txtNom1.requestFocus();
            txtNom2.setText(" ");
            txtNom2.requestFocus();
            txtRes.setText("0.00");
        }
     }
  }
  
  //Dividir
  private class Dividir extends MouseAdapter {
     float n1 = 0, n2 = 0, divicion;
     
     public void mouseClicked(MouseEvent event) {
        String x1 = txtNom1.getText();
        n1 = Integer.parseInt(x1);
        String x2 = txtNom2.getText();
        n2 = Integer.parseInt(x2);
        try {
          divicion = n1 / n2;
          txtRes.setText(String.valueOf(divicion));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor no es correcto");
            txtNom1.setText(" ");
            txtNom1.requestFocus();
            txtNom2.setText(" ");
            txtNom2.requestFocus();
            txtRes.setText("0.00");
        }
        if (txtNom2.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "La divicion entre 0 no es valida", "Error", JOptionPane.ERROR_MESSAGE);
            txtNom2.setText(null);
            txtNom2.requestFocus();
        }
     }
  }
  
  private class MyListener extends MouseAdapter
  {
   public void mouseClicked(MouseEvent event) {
      System.exit(0);
   }
  }
}