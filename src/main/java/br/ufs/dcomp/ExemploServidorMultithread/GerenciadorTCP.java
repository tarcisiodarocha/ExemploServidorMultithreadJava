package br.ufs.dcomp.ExemploServidorMultithread;

import java.net.Socket;

/**
 * 
 *
 */
public class GerenciadorTCP extends Thread 
{
    private Socket socket;
    
    public GerenciadorTCP(Socket socket)
    {
        this.socket = socket;
    }
    
    public void run(){
        
    }
}
