import acm.graphics.GImage;

public class Projectile extends GameObject {
	private int // xSpeed = 6,
	ySpeed = 6;
	// We will only have one image for the player, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	// This function will update the player's sprite to its correct location on
	// the window
	private boolean dir = true;

	public void update(int width, int height) {
		if (dir == false) {
			ySpeed = 0;
		}

		if (dir == true) {
			// ySpeed=6;
			this.y -= 1;
		}

		if (this.y == 0) {
			dir = false;
		}
		// this.y+=1;
		// this.y+=this.ySpeed;

	}

	public GImage getImg() {
		return img;
	}
}