// This file will contain the code relevant to our 'Player'
// Since this class will have images, we import the GImage object
import acm.graphics.GImage;

public class Cat extends GameObject {
	private int xSpeed = 6, ySpeed = 0;
	private int wallHits = 0;
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	// This function will update the player's sprite to its correct location on
	// the window
	private boolean dir = true;

	public void update(int width, int height) {

		if (dir == true) {
			this.x += this.xSpeed;
		}
		if (dir == false) {
			this.x -= this.xSpeed;
		}

		if (this.x < 0/* left side */) {
			wallHits++;
			this.dir = true;

		}
		if (this.x + getImg().getWidth() > width) {
			wallHits++;
			this.dir = false;

		}

		if (wallHits >= 5) {
			this.y += 1;
			// wallHits=0;
			this.ySpeed += 6;
		}

		if (this.y + 32 > 650) {
			this.y = 0;
		}
		// this.y+=1;
		// this.y+=this.ySpeed;

	}

	public GImage getImg() {
		return img;
	}
}
