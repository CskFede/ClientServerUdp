import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        // Creazione del socket di invio
        DatagramSocket clientSocket = new DatagramSocket();
        // Indirizzo IP del server
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = "Hello, server!";
        sendData = sentence.getBytes();
        // Creazione del pacchetto di invio
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        // 1. Invio del pacchetto unicast
        clientSocket.send(sendPacket);
        // 2. Ricezione della risposta
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("From Server: " + modifiedSentence);
        // Chiusura del socket di invio
        clientSocket.close();
        // Creazione del socket di invio multicast
        DatagramSocket multicastSocket = new DatagramSocket();
        // Indirizzo IP del gruppo multicast
        InetAddress groupAddress = InetAddress.getByName("230.0.0.1");
        String multicastSentence = "Hello, multicast!";
        sendData = multicastSentence.getBytes();
        // Creazione del pacchetto di invio multicast
        DatagramPacket multicastPacket = new DatagramPacket(sendData, sendData.length, groupAddress, 9876);
        // 3. Invio del pacchetto multicast
        multicastSocket.send(multicastPacket);
        // Chiusura del socket di invio multicast
        multicastSocket.close();
    }
}
