import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {
 public static void main(String argv[]) throws Exception {
  
  String serverIP = "137.135.141.116";
  int serverPort = 6666;
  int N;
  String username;
  //promt input from user
  Scanner inFromUser = new Scanner(System.in);
  System.out.println("Please enter username: ");
  username = inFromUser.next();
  //create a socket 
  Socket clientSocket = new Socket(serverIP, serverPort);
  System.out.println("Socket olusturuldu ve adresi: " + clientSocket.getRemoteSocketAddress());
  //create a DataOutPutStream object to send data
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  // create an object to collect data from server
  System.out.println("DataOutPut objesi olusturuldu.");
  //send username in Byte
  outToServer.writeUTF(username);
  System.out.println("username gonderildi.");
  // value comes from server assign to N
  //InputStream inFromServer = clientSocket.getInputStream();
  //DataInputStream N = new DataInputStream(inFromServer);
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  System.out.println("Serverdan okuyacak obje olusturuldu");
  System.out.println("N is " + inFromServer.read()); 
  clientSocket.close();
 }
}
