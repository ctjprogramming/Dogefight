import acm.program.GraphicsProgram;

// Game class is what will be run while launching the game
public class Game extends GraphicsProgram {
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
	Cat cat = new Cat();
	Projectile projectile = new Projectile();
	
	private Handler projHandler = new ProjectileHandler(this),
			catHandler = new CatHandler(this),
			plyHandler = new PlayerHandler(this);

	
	
	// MAIN FUNCTION
	public static void main(String args[]) {
		new Game().start(args);
	}

	// GAME STARTS HERE
	@Override
	public void run() {
		// GAME INIT
		addMouseListeners();
		addKeyListeners(inputs);
		addImages();
		plyHandler.setup();
		catHandler.setup();
		waitForClick(); // Must click to start game
		// GAME LOOP
		while (loop) {
			inputs.update(); // Get updated key values
			keyActions(); // Act on those values

			// UPDATING
			update();

			// RENDERING
			player.draw(); // Update the player's sprite's position given the player's coords
			cat.draw();
			projectile.draw();
			pause(1000.0 / Game.FPS); // Set FPS
		}
	}

	public void addImages() {
		this.player.addImages(this);
		this.cat.addImages(this);
	}

	public void keyActions() {
		this.player.keyActions(this, this.inputs);
	}

	public void update() {
		this.player.update(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
		cat.update(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
	}
}
