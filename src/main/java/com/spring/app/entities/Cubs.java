package com.spring.app.entities;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements Team {

	public String getName() {
		return "Chicago cubs";
	}

	@Override
	public String toString() {
		return "Cubs";
	}
}
