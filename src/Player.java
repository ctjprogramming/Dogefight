// This file will contain the code relevant to our 'Player'


// Since this class will have images, we import the GImage object
import acm.graphics.GImage;
// We begin by defining the Player class
public class Player extends GameObject {
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	
	public void update(int width, int height){
		clamp(width, height);
	}
	
	/**
	 * This function locks the player to the window, preventing him from leaving it
	 */
	public void clamp(int width, int height){
		// This is done by using the coords of the player and the player's width and height
		// to decide if the player is out of the window or not, and move him back in if he is
		if(this.x < 0){this.x = 0;} // if player is too far left
		if(this.y < 0){this.y = 0;} // if player is too high
		if(this.x + getImg().getWidth() > width){this.x = width - getImg().getWidth();} // if player is too for right, accounting for the player's top left anchor and width
		if(this.y + getImg().getHeight() > height){this.y = height - getImg().getHeight();} // if player is too low, accounting for the players top left anchor and height
	}
	// Add the images from the player to the Game class variable scope
	public void addImages(Game main){
		main.add(getImg());
	}
	/**
	 * React to user input from arrow keys
	 * @param main The game object
	 * @param inputs The input handler object
	 */
	public void keyActions(Game main, Inputs inputs){
		if(inputs.key_left){this.x -= 6;}
		if(inputs.key_right){this.x += 6;}
	}

	public GImage getImg() {
		return img;
	}
}
