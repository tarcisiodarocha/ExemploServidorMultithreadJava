package br.ufs.dcomp.ExemploServidorMultithread;

import java.net.*;

/**
 * 
 *
 */
public class ServidorLembretes
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket server = new ServerSocket(2233);
        
        System.out.println("Aguardando solicitações de lembrete...");
        while (true){
            // Aguarda cliente solicitar conexão
            Socket connection = server.accept(); 
            
            // Cria uma nova thread para tratar a conexão aceita
            ThreadLembrete lembrete = new ThreadLembrete(connection);
            
            // Inicia a thread
            lembrete.start();
        } 
        
    }
}
