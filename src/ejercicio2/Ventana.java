package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ventana extends JFrame {
    JPanel panel;
    JRadioButton rb1, rb2, rb3;
    JLabel imagen;
    public Ventana() {
        this.setSize(500, 500);
        this.setTitle("ejercicio2.Ventana");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
    }

    private void iniciar() {
        colocarPanel();
        colocarSelector();
        colocarTexto();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }

    private void colocarTexto() {
        JLabel label = new JLabel("Selecciona tu deporte favorito");
        label.setBounds(10, 10, 400, 20);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);
    }

    private void colocarSelector() {
        rb1 = new JRadioButton("Futbol");
        rb1.setBounds(10, 40, 100, 20);
        panel.add(rb1);

        rb2 = new JRadioButton("Baloncesto");
        rb2.setBounds(10, 60, 100, 20);
        panel.add(rb2);

        rb3 = new JRadioButton("Tenis");
        rb3.setBounds(10, 80, 100, 20);
        panel.add(rb3);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rb1);
        grupo.add(rb2);
        grupo.add(rb3);

        eventoAcction();

    }

    private void eventoAcction() {
        imagen = new JLabel();
        imagen.setBounds(150,50,300,200);
        panel.add(imagen);

        final ImageIcon imagenFutbol = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagenes/futbol.jpg")));
        final ImageIcon imagenBaloncesto = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagenes/baloncesto.jpg")));
        final ImageIcon imagenTenis = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagenes/tenis.jpg")));

        ActionListener evento1 = e -> {
        imagen.setIcon(new ImageIcon(imagenFutbol.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH)));
        imagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        };

        ActionListener evento2 = e -> {
            imagen.setIcon(new ImageIcon((imagenBaloncesto.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH))));
            imagen.setBorder(BorderFactory.createLineBorder(Color.green));
        };

        ActionListener evento3 = e -> {
            imagen.setIcon(new ImageIcon((imagenTenis.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH))));
            imagen.setBorder(BorderFactory.createLineBorder(Color.red));
        };

        rb1.addActionListener(evento1);
        rb2.addActionListener(evento2);
        rb3.addActionListener(evento3);
    }



}
