import acm.graphics.GImage;


public abstract class GameObject {
	public double x = 0;
	public double y = 0;

	abstract void update(int width, int height);
	public abstract GImage getImg();
	
	/**
	 * Add the images from the player to the Game class variable scope
	 * @param main The game class
	 */
	public void addImages(Game main) {
		main.add(getImg());
	}
	
	/**
	 * Set the player's sprite to its coordinates.
	 */
	public void draw(){
		getImg().setLocation(this.x, this.y);
	}
}
