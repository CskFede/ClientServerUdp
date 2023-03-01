# ClientServerUdp
Le principali classi interessate alla comunicazione sono:

DatagramSocket: rappresenta un socket per la comunicazione UDP. Viene utilizzato sia dal server che dal client per inviare e ricevere pacchetti.
DatagramPacket: rappresenta un pacchetto UDP, che contiene i dati da trasferire, l'indirizzo IP e la porta di destinazione. Viene utilizzato sia dal server che dal client per creare e ricevere pacchetti.
InetAddress: rappresenta un indirizzo IP, utilizzato dal client per indicare l'indirizzo IP del server e dall'invio multicast per indicare l'indirizzo IP del gruppo multicast.
MulticastSocket: rappresenta un socket per la comunicazione multicast. Viene utilizzato solo dal client per inviare pacchetti multicast.

