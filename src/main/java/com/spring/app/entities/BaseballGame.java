package com.spring.app.entities;

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
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
