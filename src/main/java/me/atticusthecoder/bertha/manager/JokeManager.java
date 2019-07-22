package me.atticusthecoder.bertha.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.atticusthecoder.bertha.common.Joke;
import me.atticusthecoder.bertha.common.Module;

public class JokeManager extends Module {
	public JokeManager() {
		super("Joke Manager", "Atticus Zambrana");
	}
	
	public List<Joke> jokes;

	@Override
	public void onLoad() {
		// Add our jokes
		
		jokes = new ArrayList<Joke>();
		
		jokes.add(new Joke("You know whats funny?", "my life"));
		jokes.add(new Joke("Today at the bank, an old lady asked me to help check her balance.", "So I pushed her over."));
		jokes.add(new Joke("I bought some shoes from a drug dealer.", "I don't know what he laced them with, but I've been tripping all day."));
		jokes.add(new Joke("I told my girlfriend she drew her eyebrows too high.", "She seemed surprised."));
		jokes.add(new Joke("My dog used to chase people on a bike a lot.", "It got so bad, finally I had to take his bike away."));
		jokes.add(new Joke("I'm so good at sleeping.", "I can do it with my eyes closed."));
		// for more jokes lmao
//		jokes.add(new Joke("", ""));
//		jokes.add(new Joke("", ""));
	}
	
	public Joke getRandomJoke() {
		Random r = new Random();
		int i = r.nextInt(jokes.size());
		return jokes.get(i);
	}
}
