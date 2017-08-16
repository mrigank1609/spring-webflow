package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	@Override
	public void perform() throws PerformerException {
		//System.out.println("SInger is now singing.....");
		throw new PerformerException();

	}

}
