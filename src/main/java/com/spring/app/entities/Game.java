package com.spring.app.entities;

public interface Game {
	
	public Team getHomeTeam() ;
	public void setHomeTeam(Team homeTeam) ;
	public void setAwayTeam(Team awayTeam) ;
	public Team getAwayTeam() ;
	public String playGame() ;
}
