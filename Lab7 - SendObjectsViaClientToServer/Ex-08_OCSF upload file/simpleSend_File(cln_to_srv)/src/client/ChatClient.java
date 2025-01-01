// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import java.io.*;
import java.util.Scanner;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    clientUI.display(msg.toString());
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {  
	  Scanner scanner = new Scanner(System.in);

      // Get file name
      System.out.print("Enter the name of the file: ");
      String name = scanner.nextLine();

      // Get file path
      System.out.print("Enter the file path: ");
      String path = scanner.nextLine();
	  
	  
	  MyFile msg= new MyFile(name);
	  String LocalfilePath= path;
		
	  try{

		      File newFile = new File (LocalfilePath);
		      		      
		      byte [] mybytearray  = new byte [(int)newFile.length()];
		      FileInputStream fis = new FileInputStream(newFile);
		      BufferedInputStream bis = new BufferedInputStream(fis);			  
		      
		      msg.initArray(mybytearray.length);
		      msg.setSize(mybytearray.length);
		      
		      bis.read(msg.getMybytearray(),0,mybytearray.length);
		      sendToServer(msg);		      
		    }
		catch (Exception e) {
			System.out.println("Error send (Files)msg) to Server");
		}
	  scanner.close();
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
