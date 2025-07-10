package br.ufs.dcomp.ExemploServidorMultithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 
 *
 */
public class ThreadLembrete extends Thread
{
    private Socket socket;
    
    public ThreadLembrete(Socket socket)
    {
        this.socket = socket;
    }
    
    public void run(){
        try{
            
            // Obtenção dos canais de entrada e saída da conexão
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            // Obtenção dos parâmetros para o processo de envio de lembretes
            String nome = in.readUTF();
            int intervalo = in.readInt();
            int total = in.readInt();
            
            System.out.println("   Lembrete solicitado: "+nome +"(intervalo=" + intervalo+"; total="+total+")");
            
            // Envio dos lembretes para o cliente que requisitou
            for (int i = 1; i <= total; i++){
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String dataHoraFormatada = agora.format(formatter);
                out.writeUTF("Tomar "+ nome + " "+i+ " em "+ dataHoraFormatada);
                Thread.sleep(1000*intervalo);
            }

            System.out.println("Lembrete concluído: "+ nome);            
        } catch(Exception e){System.out.println(e);} 
    }
}
