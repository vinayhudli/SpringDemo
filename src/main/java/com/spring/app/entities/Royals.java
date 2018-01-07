package com.spring.app.entities;

import org.springframework.stereotype.Component;

@Component
public class Royals implements Team {

	public String getName() {
		return "Kansas city royals";
	}

	@Override
	public String toString() {
		return "Royals";
	}
}
