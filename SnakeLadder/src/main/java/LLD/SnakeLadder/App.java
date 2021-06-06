package LLD.SnakeLadder;

import java.util.Scanner;
import metadto.Game;
import metadto.Utils;

/**
 *  Snake Ladder Game
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        
    	//Read Board Size, Board can be of any size
    	//Assume 2 players are playing
    	System.out.println( "Enter Board Size : ");
        int boardSize = sc.nextInt();

        //Random number of snakes
        int snakeCount = Utils.generate(1, boardSize*boardSize);

        //Random number of ladders
        int ladderCount = Utils.generate(1, boardSize*boardSize);
        
        Game game = new Game();
        System.out.println("GAME STARTED!!");
        game.play(2, boardSize, snakeCount, ladderCount);
        System.out.println("GAME OVER!!");
        sc.close();
    }
}
