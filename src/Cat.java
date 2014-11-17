import acm.graphics.GImage;

public class Cat extends GameObject {
	private int xSpeed = 6, ySpeed = 0;
	private int wallHits = 0;
	// We will only have one image for the cat, this bucket.
	public static final GImage img = new GImage("assets/pics/bucket.png");
	private boolean dir = true; //false = left, true = right

	public void update(int width, int height) {
		if (dir)
			this.x += this.xSpeed;
		else
			this.x -= this.xSpeed;

		if (this.x < 0 /* left side */) {
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
