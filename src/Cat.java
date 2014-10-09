// This file will contain the code relevant to our 'Player'
// Since this class will have images, we import the GImage object
import acm.graphics.GImage;
// We begin by defining the Player class
public class Cat {
	// The player has an x and y value on the window, or grid of pixels
	public double x = 0;
	public double y = 0;
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	// This function will update the player's sprite to its correct location on the window
	public void update(){
		//TODO randomly move from side to side inside of the screen
		boolean direction = (int)Math.random() * 2 == 0 ? false : true;
		
	}
	public static void main(String[] args){
		for(int i = 0; i<50;i++){
			System.out.println((int)Math.random() * 2 == 0);
		}
	}
	
	public void draw(){
		Cat.img.setLocation(this.x, this.y); // Set the player's sprite to its coords
	}
	// This function locks the player to the window, preventing him from leaving it
	public void clamp(int width, int height){
		//TODO if cat is off screen, delete self
	}
	// Add the images from the player to the Game class variable scope
	public void addImages(Game main){
		main.add(Cat.img);
	}
}
