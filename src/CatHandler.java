
public class CatHandler extends Handler {

	CatHandler(Game game) {
		super(game);
	}

	void setup() {
		game.cat.x = 0;
		game.cat.y = 0;
	}

	void draw() {
		game.inputs.update();
		game.cat.update(Game.APPLICATION_WIDTH, Game.APPLICATION_HEIGHT);
		game.cat.draw();
	}
}
