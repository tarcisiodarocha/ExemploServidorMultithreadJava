package br.ufs.dcomp.ExemploServidorMultithread;

import java.io.OutputStream;

/**
 * 
 *
 */
public class Lembrete extends Thread
{
    private String nome;
    private int intervalo;
    private int total; 
    private OutputStream out;
    
    public Lembrete(String nome, int intervalo, int total, OutputStream out)
    {
        this. nome = nome;
        this. intervalo = intervalo;
        this.total = total;
        this.out = out;
    }
    
    public void run(){
        
    }
}
