/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgameproject;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHandler
{
    public static boolean connected = false;
    private static         Socket MyClient;
    private static         BufferedReader br;
    private static         PrintWriter out;
    static int boardArray[] = new int[20];
    
	private static String hostIP = null;
	private static int hostPort = -1;
        
//	private static Socket server = null;
//	private static PrintWriter serverOut = null;
//	private static BufferedReader serverIn = null;

	public static void connect(String ip, int port) throws UnknownHostException, IOException
	{
		hostIP = ip;
		hostPort = port;
            MyClient = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(MyClient.getInputStream()));
            out = new PrintWriter(MyClient.getOutputStream(), true);
                
                
//		server = new Socket();
//		server.connect(new InetSocketAddress(ip, port), 6000);
//		serverOut = new PrintWriter(server.getOutputStream(), true);
//		serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
		connected = true;
		recievePieceMove();
	}

	public static void disconnect()
	{
		try
		{
			if (MyClient != null)
				MyClient.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hostIP = null;
		hostPort = -1;
		MyClient = null;
		out = null;
		br = null;
		connected = false;
		BoardGameProject.gameStarted = false;
		BoardGameProject.reset();
	}
    public static void sendPieceMove(String masonForehead)
    {
		if (connected)
		{
//add or modify.       /
                        out.println(masonForehead + ":" + -1 + ":" + -1);
                        out.flush(); 
                        BoardGameProject.myTurn = false;
		}        
    }

	public static void sendDisconnect()
	{
		if (connected)
		{
			out.println("esc");
		}
	}
        public static void sendBuilding(int buildingType, int xpos, int ypos){
            out.println(buildingType + ":" + xpos + ":" + ypos + ":" + -1 + ":" + -3);
            out.flush();  
        }
        


	public static void recievePieceMove()
	{
		new Thread(new Runnable() {

			@Override
			public void run()
			{
				String inputLine;

				try
				{
					while ((inputLine = br.readLine()) != null)
					{
						try
						{
							if (inputLine.equals("esc"))
							{
								disconnect();
								return;
							}
//add or modify.
							// row:col:initrow:initcol
                                                        
//                                                        if(BoardGameProject.receivingBoardFirst){
//                                                            boardArray[0] = Integer.parseInt(inputLine.split(":")[0]);
//                                                            boardArray[1] = Integer.parseInt(inputLine.split(":")[1]);
//                                                            boardArray[2] = Integer.parseInt(inputLine.split(":")[2]);
//                                                            boardArray[3] = Integer.parseInt(inputLine.split(":")[03]);
//                                                            boardArray[4] = Integer.parseInt(inputLine.split(":")[04]);
//                                                            boardArray[5] = Integer.parseInt(inputLine.split(":")[05]);
//                                                            boardArray[6] = Integer.parseInt(inputLine.split(":")[06]);
//                                                            boardArray[7] = Integer.parseInt(inputLine.split(":")[07]); 
//                                                            BoardGameProject.receivingBoardFirst = false;
//                                                            
//                                                        }
//                                                        else if(BoardGameProject.receivingBoardSecond){
//                                                            boardArray[8] = Integer.parseInt(inputLine.split(":")[0]);
//                                                            boardArray[9] = Integer.parseInt(inputLine.split(":")[1]);
//                                                            boardArray[10] = Integer.parseInt(inputLine.split(":")[2]);
//                                                            boardArray[11] = Integer.parseInt(inputLine.split(":")[03]);
//                                                            boardArray[12] = Integer.parseInt(inputLine.split(":")[04]);
//                                                            boardArray[13] = Integer.parseInt(inputLine.split(":")[05]);
//                                                            boardArray[14] = Integer.parseInt(inputLine.split(":")[06]);
//                                                            boardArray[15] = Integer.parseInt(inputLine.split(":")[07]); 
//                                                            BoardGameProject.receivingBoardSecond = false;
//                                                        }
//                                                        else if(BoardGameProject.receivingBoardThird){
//                                                            boardArray[16] = Integer.parseInt(inputLine.split(":")[0]);
//                                                            boardArray[17] = Integer.parseInt(inputLine.split(":")[1]);
//                                                            boardArray[18] = Integer.parseInt(inputLine.split(":")[2]);
//                                                            boardArray[19] = Integer.parseInt(inputLine.split(":")[03]);
//                                                        }
                                                        if(Integer.parseInt(inputLine.split(":")[4]) == -1){
                                                            Dice.setNum1(Integer.parseInt(inputLine.split(":")[0]));
                                                            Dice.setNum2(Integer.parseInt(inputLine.split(":")[1]));
                                                            BoardGameProject.serverValue = Integer.parseInt(inputLine.split(":")[2]);         
                                                            BoardGameProject.myTurn = true;
                                                            BoardGameProject.extraForPhaseGame1 = 1;
                                                        }else if(Integer.parseInt(inputLine.split(":")[4]) == -2){
                                                            Board.setHexBoard(Integer.parseInt(inputLine.split(":")[0]), Integer.parseInt(inputLine.split(":")[1]), Integer.parseInt(inputLine.split(":")[2]), Integer.parseInt(inputLine.split(":")[3]));
                                                        }else if(Integer.parseInt(inputLine.split(":")[4]) == -3){
                                                            if(Integer.parseInt(inputLine.split(":")[0]) == 1)
                                                                Settlements.settlements.add(new Settlements(Integer.parseInt(inputLine.split(":")[1]), Integer.parseInt(inputLine.split(":")[2])));
                                                            else if(Integer.parseInt(inputLine.split(":")[0]) == 2){
                                                                Roads.roads.add(new Roads(Integer.parseInt(inputLine.split(":")[1]), Integer.parseInt(inputLine.split(":")[2])));
                                                                if(BoardGameProject.phaseOfGame == 2)
                                                                    BoardGameProject.playerTurnOrder += 1;
							    }
						   	    else if(Integer.parseInt(inputLine.split(":")[0]) == 3)
								Cities.cities.add(new Cities(Integer.parseInt(inputLine.split(":")[1]), Integer.parseInt(inputLine.split(":")[2])));
							}
                                                        
                                                        
						}
						catch (NumberFormatException e)
						{
							e.printStackTrace();
						}
						catch (NullPointerException e)
						{
							disconnect();
						}
					}
				}
				catch (IOException e)
				{
					disconnect();
				}

			}
		}).start();
	}

	public static boolean isConnected()
	{
		return connected;
	}
}
