/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Daniel Noblecias
 */
public class InstCmd {

    private static final String EXEC = "cmd";
    private PrintWriter stdin;
    private Process p;

    private BufferedReader stdInput;
    private InputStreamReader entrada;

    public InstCmd() {
        try {

            p = Runtime.getRuntime().exec(EXEC);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            stdin = new PrintWriter(p.getOutputStream());

            entrada = new InputStreamReader(p.getInputStream());
            stdInput = new BufferedReader(entrada);
        } catch (IOException e) {
            System.err.println("Error I/O");
        }
    }

    public BufferedReader nvInstruccion(String instruccion) {
        stdin.println(instruccion);
        return stdInput;
    }

    public BufferedReader nvInstruccion(ArrayList<String> instrucciones) {
        for (String intruccion : instrucciones) {
            stdin.println(intruccion);
        }
        stdin.close();
        return stdInput;
    }

    public void finalizarInst() {
        this.stdin.close();
    }

}
