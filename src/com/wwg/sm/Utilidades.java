/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Daniel
 */
public class Utilidades {

    public static File slcArc() {
        File arR = null;

        JFileChooser slcA = new JFileChooser(new File("."));
        slcA.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        slcA.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return (f.isDirectory()
                        || (f.isFile() && (f.getName().endsWith(".xlsx") || f.getName().endsWith(".xls"))));
            }

            @Override
            public String getDescription() {
                return "Solo excel";
            }
        });

        int rsl = slcA.showOpenDialog(null);
        if (rsl == JFileChooser.APPROVE_OPTION) {
            arR = slcA.getSelectedFile();
        }
        return arR;
    }

    public static String obtUnidad(String ruta) {
        String salida = "";
        char[] cadena = ruta.toCharArray();
        for (char c : cadena) {
            if (c != ':') {
                salida += c;
            } else {
                salida += c;
                break;
            }
        }
        return salida;
    }

    public static void leerCns(InstCmd cmd) {
        String salida = "";
        BufferedReader br = cmd.getStdInput();
        try {
            while ((salida = br.readLine()) != null) {
                System.out.println(salida);
            }
        } catch (IOException e) {
            System.out.println("Error I/O");
        }
    }

}
