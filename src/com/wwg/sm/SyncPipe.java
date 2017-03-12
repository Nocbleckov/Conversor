/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wwg.sm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Daniel Noblecias
 */
public class SyncPipe implements Runnable{

    private final InputStream istrm_;
    private final OutputStream ostrm_;

    public SyncPipe(InputStream istrm, OutputStream ostrm) {
        istrm_ = istrm;
        ostrm_ = ostrm;
    }

    public void run() {
        try {
            final byte[] buffer = new byte[1024];
            for (int length = 0; (length = istrm_.read(buffer)) != -1;) {
                ostrm_.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
