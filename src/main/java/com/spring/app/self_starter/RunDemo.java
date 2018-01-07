package com.spring.app.self_starter;

import java.text.NumberFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.configuration.AppConfiguration;
import com.spring.app.entities.Cubs;
import com.spring.app.entities.Game;
import com.spring.app.entities.RedSox;
import com.spring.app.entities.Royals;
import com.spring.app.entities.Team;

public class RunDemo {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class) ;
		
		Game game = context.getBean("getGame" ,Game.class) ;
		Team royals = context.getBean("royals", Royals.class) ;
		Team redSox = context.getBean("redSox", RedSox.class) ;
		Team cubs = context.getBean("Cubs", Cubs.class) ;
		
		game.setHomeTeam(cubs);
		game.setAwayTeam(redSox);
		System.out.println("first game : "+game.playGame());
		
		game.setHomeTeam(redSox);
		game.setAwayTeam(royals);
		System.out.println("seconds game : "+game.playGame());
		
		for(String name : context.getBeanDefinitionNames()){
//			System.out.println(name);
		}
		
		NumberFormat nf = context.getBean("numberFormat", NumberFormat.class) ;
//		System.out.println("currency format is : "+nf.format(1234567));
			
		((AnnotationConfigApplicationContext)context).close();
	}
}
