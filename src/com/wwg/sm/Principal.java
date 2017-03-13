/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Noblecias
 */
public class Principal {
    
    public static void main(String[] args) {

        /*String salida = "";

        /*ArrayList<String> inst = new ArrayList<>();
        inst.add("cd C:\\Users\\Daniel Noblecias\\Documents");
        inst.add("dir");*/
 /*InstCmd cmd = new InstCmd();
        cmd.nvInstruccion("cd C:\\");
        BufferedReader temp = cmd.nvInstruccion("dir");
        cmd.finalizarInst();
        try {
            while ((salida = temp.readLine()) != null) {
                System.out.println(salida);
            }
        } catch (IOException e) {
            System.out.println("Error I/O");
        }
         */
        JFrame vnt = new JFrame("Some");
        vnt.setVisible(true);
        vnt.setSize(800, 600);
        vnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vnt.setResizable(false);
        PanelPrincipal p = new PanelPrincipal();
        vnt.add(p);
        p.init();
        while (true) {
            Runnable paint = () -> {
                p.repaint();
                try {
                    Thread.sleep(120);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            };
            paint.run();
        }
        
    }
    
}
