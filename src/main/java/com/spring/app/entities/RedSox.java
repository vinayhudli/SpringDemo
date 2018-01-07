package com.spring.app.entities;

import org.springframework.stereotype.Component;

@Component
public class RedSox implements Team {

	public String getName() {
		return "Boston Red Sox";
	}

	@Override
	public String toString() {
		return "RedSox";
	}
}
