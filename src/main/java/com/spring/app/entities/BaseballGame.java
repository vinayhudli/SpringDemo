package com.spring.app.entities;

import java.sql.SQLException;

import javax.sql.DataSource;

public class BaseballGame implements Game{
	
	private Team homeTeam ;
	private Team awayTeam ;
	private DataSource dataSource ;
	
	public BaseballGame() {}
	
	public BaseballGame(Team homeTeam, Team awayTeam){
		this.homeTeam = homeTeam ;
		this.awayTeam = awayTeam ;
	}
	
	public void setDataSource(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
//		this.dataSource.getConnection() ;
	}
	
	public void startGame(){
		System.out.println("starting game");
	}
	
	public void endGame(){
		System.out.println("ending game");
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setHomeTeam(Team homeTeam){
		this.homeTeam = homeTeam ;
	}
	
	public void setAwayTeam(Team awayTeam){
		this.awayTeam = awayTeam ;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public String playGame() {
		return Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName() ;
	}

}
