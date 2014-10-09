// These imports aren't necessary yet, but they will be later

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
// Basic imports for the ACM library
import acm.graphics.*;
import acm.program.GraphicsProgram;
// Game class is what will be run while launching the game
public class Game extends GraphicsProgram{
	// APPLICATION
	private static final long serialVersionUID = 1L;
	// Dimensions of the screen
	public static final int APPLICATION_WIDTH = 350;
	public static final int APPLICATION_HEIGHT = 650;
	// FRAME RATE / CYCLES
	public static final int FPS = 60;
	public static boolean loop = true; // Controls if game is running
	// KEYS
	Inputs inputs = new Inputs();
	// PLAYER
	Player player = new Player();
	
	// MAIN FUNCTION
	public static void main(String args[]){
		new Game().start(args);
	}
	// GAME STARTS HERE
	public void run(){
		// GAME INIT
		addMouseListeners();
		addKeyListeners(inputs);
		addImages();
		setupPlayer();
		waitForClick(); // Must click to start game
		// GAME LOOP
		while(loop){
			inputs.update(); // Get updated key values
			keyActions(); // Act on those values
			this.player.clamp(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT); // Clamp the player to the window
			player.draw(); // Update the player's sprite's position given the player's coords
			pause(1000.0 / Game.FPS); // Set FPS
		}
	}
	
	public void setupPlayer(){
		this.player.x = APPLICATION_WIDTH / 2 - Player.img.getWidth() / 2;
		this.player.y = APPLICATION_HEIGHT - Player.img.getHeight() * 1.5;
	}
	
	public void drawPlayer(){
		inputs.update();
		this.player.clamp(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
		player.draw();
		
	}
	
	public void addImages(){
		this.player.addImages(this);
	}
	
	public void keyActions(){
		this.player.keyActions(this, this.inputs);
	}
}

