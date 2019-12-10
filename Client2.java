import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
 public static void main(String args[]) throws Exception {
  
  String serverIP = "137.135.141.116";
  int serverPort = 6666;
  int N;
  String username;
 
  //prompt username from user
  Scanner input = new Scanner(System.in);
  System.out.print("Please enter your username: ");
  username = input.next();
  
  // encode username to ascii
  byte[] usernameBuffer;
  usernameBuffer = username.getBytes("US-ASCII");
  System.out.println("ascii encoded username: " + usernameBuffer);
  
  // create a TCP socket
  Socket clientSocket = new Socket(serverIP, serverPort);
  System.out.println("Socket olusturuldu ve adresi: " + clientSocket.getRemoteSocketAddress());
  
  //create a DataOutPutStream object to send data
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  System.out.println("DataOutPut objesi olusturuldu.");
  
  //send username in Byte
  outToServer.write(usernameBuffer);
  System.out.println("ascii encoded username gonderildi." + usernameBuffer);
  
  // value comes from server assign to N
  //InputStream inFromServer = clientSocket.getInputStream();
  //DataInputStream N = new DataInputStream(inFromServer);
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  System.out.println("Serverdan okuyacak obje olusturuldu");
  System.out.println("N is " + inFromServer.read());
  
  //close socket
  clientSocket.close();
  
 }
}
