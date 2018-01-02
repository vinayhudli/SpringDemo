package com.spring.app.self_starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.configuration.AppConfiguration;
import com.spring.app.entities.Game;

public class RunDemo {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class) ;
		
		Game game = context.getBean("getGame" ,Game.class) ;
		System.out.println(game.playGame());
		
		for(String name : context.getBeanDefinitionNames()){
			System.out.println(name);
		}
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
