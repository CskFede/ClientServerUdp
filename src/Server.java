import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        // Creazione del socket di ricezione
        DatagramSocket serverSocket = new DatagramSocket(9876);
        // Definizione degli array di byte per i dati da ricevere e da inviare
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        // Ciclo infinito per ricevere e gestire i pacchetti in arrivo
        while (true) {
            // 1. Ricezione del pacchetto
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            // Conversione dei dati ricevuti in una stringa
            String sentence = new String(receivePacket.getData());
            // Stampa a console della stringa ricevuta
            System.out.println("Received: " + sentence);
            // Ottenimento dell'indirizzo IP e della porta del mittente
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            // Trasformazione della stringa ricevuta in maiuscolo
            String capitalizedSentence = sentence.toUpperCase();
            // Definizione dei dati da inviare come un array di byte
            sendData = capitalizedSentence.getBytes();
            // 2. Invio della risposta
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}

