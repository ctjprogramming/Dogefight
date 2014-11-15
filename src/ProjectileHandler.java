
public class ProjectileHandler extends Handler {
	
	public ProjectileHandler(Game game) {
		super(game);
	}

	void setup() {
		game.projectile.x = game.player.x;
		game.projectile.y = game.player.y;
	}

	void draw() {
		game.inputs.update();
		game.projectile.update(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
		game.projectile.draw();
	}

}
