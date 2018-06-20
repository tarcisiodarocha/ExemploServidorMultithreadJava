package br.ufs.dcomp.ExemploServidorMultithread;

import java.net.*;
import java.io.*;

/**
 * 
 *
 */
public class Cliente3 
{
    public static void main( String[] args ) throws Exception
    {
        // Estabelece conexão com o servidor de lembretes
        Socket socket = new Socket("localhost", 2233);
        
        // Obtem os canais de entrada e saída da conexão
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Define os parâmetros para o servidor de lembretes
        String nome = "Cataflan";
        int intervalo = 6;
        int total = 16;

        // Envia os parâmetros para o servidor de lembretes
        out.writeUTF(nome);
        out.writeInt(intervalo);
        out.writeInt(total);
        
        // Recebe os lembretes do servidor
        for (int i = 0; i<total; i++){
            // Aguarda servidor responder com o lembrete e o captura
            String msg = in.readUTF();
            // Exibe o lembrete 
            System.out.println(msg);
        }
        
        
        
 
    }
}
