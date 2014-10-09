// This file will contain the code relevant to our 'Player'
// Since this class will have images, we import the GImage object
import acm.graphics.GImage;
// We begin by defining the Player class
public class Player {
	// The player has an x and y value on the window, or grid of pixels
	public double x = 0;
	public double y = 0;
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	// This function will update the player's sprite to its correct location on the window
	public void draw(){
		Player.img.setLocation(this.x, this.y); // Set the player's sprite to its coords
	}
	// This function locks the player to the window, preventing him from leaving it
	public void clamp(int width, int height){
		// This is done by using the coords of the player and the player's width and height
		// to decide if the player is out of the window or not, and move him back in if he is
		if(this.x < 0){this.x = 0;} // if player is too far left
		if(this.y < 0){this.y = 0;} // if player is too high
		if(this.x + Player.img.getWidth() > width){this.x = width - Player.img.getWidth();} // if player is too for right, accounting for the player's top left anchor and width
		if(this.y + Player.img.getHeight() > height){this.y = height - Player.img.getHeight();} // if player is too low, accounting for the players top left anchor and height
	}
	// Add the images from the player to the Game class variable scope
	public void addImages(Game main){
		main.add(Player.img);
	}
	// React to user input from arrow keys
	public void keyActions(Game main, Inputs inputs){
		if(inputs.key_left){this.x -= 6;}
		if(inputs.key_right){this.x += 6;}
	}
}
