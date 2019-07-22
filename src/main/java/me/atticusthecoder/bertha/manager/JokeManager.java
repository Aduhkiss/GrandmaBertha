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
		
		jokes.add(new Joke("You know whats funny?", "my life", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("Today at the bank, an old lady asked me to help check her balance.", "So I pushed her over.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("I bought some shoes from a drug dealer.", "I don't know what he laced them with, but I've been tripping all day.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("I told my girlfriend she drew her eyebrows too high.", "She seemed surprised.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("My dog used to chase people on a bike a lot.", "It got so bad, finally I had to take his bike away.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("I'm so good at sleeping.", "I can do it with my eyes closed.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("My boss told me to have a good day..", "so I went home.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("Why is Peter Pan always flying?", "He neverlands.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("A woman walks into a library and asked if they had any books about paranoia.", "The librarian says \"They're right behind you!\"", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("The other day, my wife asked me to pass her lipstick but I accidentally passed her a glue stick.", "She still isn't talking to me.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("Why do blind people hate skydiving?", "It scares the hell out of their dogs.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("When you look really closely...", "all mirrors look like eyeballs.", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("My friend says to me: \"What rhymes with orange\"", "I said: \"No it doesn't\"", "AtticusWasNeverHere#6362"));
		jokes.add(new Joke("What do you call a guy with a rubber toe?", "Roberto.", "AtticusWasNeverHere#6362"));
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
