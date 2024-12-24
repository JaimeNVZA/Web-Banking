/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extracto;

/**
 *
 * @author David Gomez
 */
import javax.swing.*;
import java.awt.*;

public class ExtractoComponent extends JPanel {

    private JLabel montoLabel;
    private JLabel conceptoLabel;

    public ExtractoComponent(String concepto, double monto) {
        initComponents(concepto, monto);
    }

    private void initComponents(String concepto, double monto) {
        setLayout(new GridLayout(1, 2));

        montoLabel = new JLabel("Monto: " + String.format("%.2f", monto));
        conceptoLabel = new JLabel("Concepto: " + concepto);

        add(conceptoLabel);
        add(montoLabel);
    }

    // Métodos para establecer el concepto y el monto si es necesario
    public void setConcepto(String concepto) {
        conceptoLabel.setText("Concepto: " + concepto);
    }

    public void setMonto(double monto) {
        montoLabel.setText("Monto: " + monto);
    }

}
