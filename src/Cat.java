// This file will contain the code relevant to our 'Player'
// Since this class will have images, we import the GImage object
import acm.graphics.GImage;
// We begin by defining the Player class
public class Cat {
	// The player has an x and y value on the window, or grid of pixels
	public double x = 0;
	public double y = 0;
	private int xSpeed = 6,
			ySpeed = 0;
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	// This function will update the player's sprite to its correct location on the window
	private boolean dir = true;
	public void update(int width, int height){
		int wallHits = 0;
		if (dir)
			this.x += this.xSpeed;
		else
			this.x -= this.xSpeed;

		if (this.x < 0/* left side */) {
			this.dir = true;
			wallHits++;
		}
		if (this.x + Cat.img.getWidth() > width) {
			this.dir = false;
			wallHits++;
		}
		if (wallHits >= 2)
			this.ySpeed += 6;
		if (this.y + 32 > 650)
			this.y = 0;
		this.y += 1;
		// this.y+=this.ySpeed;

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
