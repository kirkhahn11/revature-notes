package com.revature.controller;

import java.util.List;

import static com.revature.util.ClientMessageUtil.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

@Controller
public class HeroControllerImpl implements HeroController{
	
	/**
	 * @RequestMapping (GET or POST) specifies a URL at which the method is available - binding a function to a url pattern
	 * 
	 * @ResponseBody specifies what we return to the client (typically in JSON format) Java -> JSON is called marshalling 
	 * 
	 * @RequestBody specifies the type of information the method is taking in, performs unmarshalling 
	 */
	
	
	// since our hero controler depends on service layer we need to inject taht dependency
	@Autowired
	HeroService heroService;
	
	// GET mapping specifies taht if the client sends a get request to this url, we trigger this response
	@GetMapping("/findAllHeros")
	public @ResponseBody List<Hero> findAllHeroes(){ // http://localhost:8080/SpringMVC/findAllHeros
		return heroService.getAllHeroes();
	}
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		return heroService.registerHero(hero) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}
	
	@GetMapping("/findHero")
	public @ResponseBody Hero findHero(@RequestParam String heroName) { //http://localhost:8080/SpringMVC/findHero?heroName=Kirk
		return heroService.getHero(heroName);
	}
}
