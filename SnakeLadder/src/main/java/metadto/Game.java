package metadto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Game {
	public void play(int players, int bsize, int snakes, int ladders) {
		Player[] plist = new Player[players];
		Map<Integer, Integer> snakeList = new HashMap<>();
		Map<Integer, Integer> ldrList = new HashMap<>();
		Set<String> uniquePairs = new HashSet<>();
		
		
		//Fill in player details
		for(int i=0; i<players; i++) {
			plist[i] = new Player(i+1, 1);
		}
		
		//Generate Snakes
		for(int i=1; i<=snakes; i++) {
			while(true) {
				int s = Utils.generate(1, bsize*bsize);
				int l = Utils.generate(1, bsize*bsize);
				String temp = String.valueOf(s)+l;
				if(s>l) {
					 if(!uniquePairs.contains(temp)) {
						 snakeList.put(s, l);
						 uniquePairs.add(temp);
						 break;
					 }
				}
			}
		}
		
		//Generate Ladders
		for(int i=1; i<=snakes; i++) {
			while(true) {
				int s = Utils.generate(1, bsize*bsize);
				int l = Utils.generate(1, bsize*bsize);
				String temp = String.valueOf(s)+l;
				if(s<l) {
					 if(!uniquePairs.contains(temp)) {
						 ldrList.put(s, l);
						 uniquePairs.add(temp);
						 break;
					 }
				}
			}
		}
		

		//Play Game
		boolean gameNotOver = true;
		while(gameNotOver) {
			for(int i=0; i<players; i++) {
				Player oldp = plist[i];
				
				//Player[i] is rolling dice
				int dice = Utils.generate(1, 7);
				int newPos = oldp.getPosition()+dice;
				System.out.println("Player "+ oldp.getName() + " rolled "+dice);
				
				//If new position is beyond board size, stay at same position
				if(newPos > bsize*bsize) {
					System.out.println("Player "+ oldp.getName()+" stays at : " + oldp.getPosition());
					continue;
				} 
				// If new position is winning place, quit game and declare winner
				else if(newPos == bsize*bsize) {
					System.out.println("Player "+ oldp.getName() + " won this game ");
					gameNotOver = false;
					break;
				}
				//Otherwise, conitnue game with new places of each player
				else {
					//Check for ladder
					if(ldrList.containsKey(newPos)) {
						System.out.println("Player "+ oldp.getName()+" climbed ladder :) ");
						newPos = ldrList.get(newPos);
					}
					//Check for snake
					else if(snakeList.containsKey(newPos)) {
						System.out.println("Player "+ oldp.getName()+" got bit by snake :( ");
						newPos = snakeList.get(newPos);
					}
					
					System.out.println("Player "+ oldp.getName()+" new Position : "+newPos);
					plist[i] = new Player(oldp.getName(), newPos);
				}
			}
		}
		
	}
}
