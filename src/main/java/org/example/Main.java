package org.example;

import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) throws IOException {

        int porta = 12500;
        DatagramSocket socket = new DatagramSocket(porta);

        // Recebendo a mensagem cifrada
        byte[] msgCifradaBytes = new byte[1024];
        DatagramPacket pacoteRecebidoMsgCifrada = new DatagramPacket(msgCifradaBytes, msgCifradaBytes.length);
        socket.receive(pacoteRecebidoMsgCifrada);

        // Recebendo a chave 'd'
        byte[] dBytes = new byte[256];
        DatagramPacket pacoteRecebidoChaveD = new DatagramPacket(dBytes, dBytes.length);
        socket.receive(pacoteRecebidoChaveD);

        // Recebendo a chave 'n'
        byte[] nBytes = new byte[256];
        DatagramPacket pacoteRecebidoChaveN = new DatagramPacket(nBytes, nBytes.length);
        socket.receive(pacoteRecebidoChaveN);

        // Convertendo os arrays de bytes em BigIntegers
        BigInteger msgCifrada = new BigInteger(pacoteRecebidoMsgCifrada.getData(), 0, pacoteRecebidoMsgCifrada.getLength());
        BigInteger d = new BigInteger(pacoteRecebidoChaveD.getData(), 0, pacoteRecebidoChaveD.getLength());
        BigInteger n = new BigInteger(pacoteRecebidoChaveN.getData(), 0, pacoteRecebidoChaveN.getLength());

        System.out.println("Mensagem cifrada recebida: " + msgCifrada);
        System.out.println("Chave d recebida: " + d);
        System.out.println("Chave n recebida: " + n);

        // Decifrando a mensagem
        String msgDecifrada = new String(new BigInteger(msgCifrada.toByteArray()).modPow(d, n).toByteArray());
        System.out.println("Mensagem decifrada: " + msgDecifrada);

        socket.close();

    }
}