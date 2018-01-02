package com.spring.app.self_starter;

import com.spring.app.entities.BaseballGame;
import com.spring.app.entities.Cubs;
import com.spring.app.entities.Game;
import com.spring.app.entities.RedSox;
import com.spring.app.entities.Team;

public class RunDemoWithoutSpring{
	
    public static void main( String[] args ){
    	Team redSox = new RedSox() ;
    	Team cubs = new Cubs() ;
    	Game game = new BaseballGame(redSox, cubs) ;
    	System.out.println(game.playGame());
    }
}
