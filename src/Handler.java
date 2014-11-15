
public abstract class Handler {
	protected final Game game;
	
	Handler(Game game) {
		this.game = game;
	}
	
	abstract void setup();
	abstract void draw();
}
