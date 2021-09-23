package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

@Service
public class HeroServiceImpl implements HeroService{

	// our service layer relies on the repository layer
	@Autowired
	HeroRepository heroRepository;
	
	public boolean registerHero(Hero hero) {
		int pk = heroRepository.insert(hero);
		return (pk > 0) ? true : false;
	}

	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();

	}

	public Hero getHero(String name) {
		return heroRepository.findByName(name);
	}

}
