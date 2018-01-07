package com.spring.app.configuration;

import java.sql.SQLException;
import java.text.NumberFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.spring.app.entities.BaseballGame;
import com.spring.app.entities.Cubs;
import com.spring.app.entities.Game;
import com.spring.app.entities.RedSox;
import com.spring.app.entities.Team;

@Configuration
@Import(InfrastructureConfiguration.class)
@ComponentScan(basePackages="com.spring.app.entities,com.spring.app.aspects")
@EnableAspectJAutoProxy				//to enable aspects
public class AppConfiguration {
	
	//this is autowired based on type from InfrastructureConfiguration class 
	@Autowired
	private DataSource dataSource1 ;
	
	@Autowired
	@Qualifier("redSox") //qualifier is the name of the component class with first letter in small case
	private Team away ;
	
	@Autowired
	@Qualifier("cubs")	//qualifier is the name of the component class with first letter in small case
	private Team home ;
	
	@Bean
	public Team redSox(){
		return new RedSox() ;
	}
	
	@Bean
	public Team Cubs(){
		return new Cubs() ;
	}
	
//	@Bean(initMethod="startGame", destroyMethod="endGame")
	@Bean
	@Scope("prototype")
	public Game getGame(DataSource dataSource) throws SQLException{	//datasource is injected from InfrastructureConfiguration class
//		BaseballGame game = new BaseballGame(redSox(), cubs()) ;
		BaseballGame game = new BaseballGame(home, away) ;
		game.setDataSource(dataSource1);
		return game ;
	}
	
	@Bean
	public NumberFormat numberFormat(){
		return NumberFormat.getCurrencyInstance() ;
	}
}
