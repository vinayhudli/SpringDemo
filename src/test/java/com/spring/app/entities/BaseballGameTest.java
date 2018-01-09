package com.spring.app.entities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.app.configuration.AppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)		//makes sure that the context created in the setup() method is not created for 
											//every test case, by caching the first time

@ContextConfiguration(classes=AppConfiguration.class)		//application configuration file to create context, this context will be cached by springjunitclassrunner

//This kind of test is integration test, unit test shouldn't have involved spring at all rather it would have mocked classes etc to test
public class BaseballGameTest {
	
	@Autowired
	private Game game ;
	
	@Autowired			//game and context can be autowired due to usage of springjunitclassrunner and contextconfiguration classes provided
	private ApplicationContext context ;
	
//setup() is not required as springjunitclassrunner is used to create and cache application context
	//	@Before				//this method runs before every @Test method
//	public void setUp(){
//		context = new AnnotationConfigApplicationContext(AppConfiguration.class) ;
//		game = context.getBean("getGame", Game.class) ;
//	}
	
	@Test				//actual test cases
	public void testPlayGame(){
		String homeTeam = game.getHomeTeam().getName() ;
		String awayTeam = game.getAwayTeam().getName() ;
		
		String winningTeam = game.playGame() ;
		
		Assert.assertTrue(winningTeam.equals(awayTeam) || winningTeam.equals(homeTeam));
	}
	
	@Test
	public void setGetAndSetHomeTeam(){
		Team royals = context.getBean("royals", Team.class) ;
		game.setHomeTeam(royals);
		Cubs cubs = context.getBean("cubs", Cubs.class) ;
		System.out.println("cubs name : "+cubs.getName());
		Assert.assertEquals(royals.getName(), game.getHomeTeam().getName());
	}
}
