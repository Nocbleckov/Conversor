/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Noblecias
 */
public class PanelPrincipal extends JPanel {

    JTextField textRutaOrigen;
    JTextField textRutaDestino;

    JButton btnRutaDestino;
    JButton btnRutaOrigen;

    public PanelPrincipal() {

    }

    public void init() {
        textRutaOrigen = new JTextField();
        textRutaOrigen.setBounds(10, 10, 600, 28);

        textRutaDestino = new JTextField();
        textRutaDestino.setBounds(10, 45, 600, 28);

        btnRutaOrigen = new JButton();
        btnRutaOrigen.setBounds(620, 10, 120, 28);

        btnRutaDestino = new JButton();
        btnRutaDestino.setBounds(620, 45, 120, 28);

        btnRutaOrigen.addActionListener(new ClickBtOrg());

        add(textRutaOrigen);
        add(textRutaDestino);
        add(btnRutaOrigen);
        add(btnRutaDestino);
    }

    class ClickBtOrg implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            File ruta = Utilidades.slcArc();
            if (ruta != null) {
                textRutaOrigen.setText(ruta.getPath());
                String unidad = Utilidades.obtUnidad(ruta.getPath());
                InstCmd cmd = new InstCmd();
                cmd.nvInstruccion(unidad);
                cmd.finalizarInst();
            }
        }

    }

    class ClickBtDst implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

}
