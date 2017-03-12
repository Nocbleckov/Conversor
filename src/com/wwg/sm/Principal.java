/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Daniel Noblecias
 */
public class Principal {

    public static void main(String[] args) {

        String salida = "";

        /*ArrayList<String> inst = new ArrayList<>();
        inst.add("cd C:\\Users\\Daniel Noblecias\\Documents");
        inst.add("dir");*/
        InstCmd cmd = new InstCmd();
        cmd.nvInstruccion("cd C:\\Users\\Daniel Noblecias\\Documents");
        BufferedReader temp = cmd.nvInstruccion("dir");
        cmd.finalizarInst();
        try {
            while ((salida = temp.readLine()) != null) {
                System.out.println(salida);
            }
        } catch (IOException e) {
            System.out.println("Error I/O");
        }

    }

}
