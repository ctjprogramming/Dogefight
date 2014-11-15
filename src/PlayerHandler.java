
public class PlayerHandler extends Handler {

	public PlayerHandler(Game game) {
		super(game);
	}

	void setup() {
		game.player.x = Game.APPLICATION_WIDTH / 2 - Player.img.getWidth() / 2;
		game.player.y = Game.APPLICATION_HEIGHT - Player.img.getHeight() * 1.5;
	}

	void draw() {
		game.inputs.update();
		game.player.clamp(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
		game.player.draw();
	}

}
