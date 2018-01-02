package com.spring.app.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.spring.app.entities.BaseballGame;
import com.spring.app.entities.Cubs;
import com.spring.app.entities.Game;
import com.spring.app.entities.RedSox;
import com.spring.app.entities.Team;

@Configuration
@Import(InfrastructureConfiguration.class)
public class AppConfiguration {
	
	@Bean
	public Team redSox(){
		return new RedSox() ;
	}
	
	@Bean
	public Team cubs(){
		return new Cubs() ;
	}
	
	@Bean
	public Game getGame(DataSource dataSource){
		BaseballGame game = new BaseballGame(redSox(), cubs()) ;
		game.setDataSource(dataSource);
		return game ;
	}
}
