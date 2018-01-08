package com.spring.app.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.configuration.AppConfiguration;

public class BaseballGameTest {
	
	private Game game ;
	
	@Before
	public void setUp(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class) ;
		game = context.getBean("getGame", Game.class) ;
	}
	
	@Test
	public void testPlayGame(){
		String homeTeam = game.getHomeTeam().getName() ;
		String awayTeam = game.getAwayTeam().getName() ;
		
		String winningTeam = game.playGame() ;
		
		Assert.assertTrue(winningTeam.equals(awayTeam) || winningTeam.equals(homeTeam));
	}
}
