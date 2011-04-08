import java.util.Collection;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

public class Base extends BasicGame {
	static private final int screenWidth = 800;
	static private final int screenHeight = 600;
	
	private Camera camera;
	
	public Base() {
		super("Cube3D");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		camera = new Camera(new Vector3D(500,0,0), 0,0,0);
		//Game game = new Game(); For when the Game class exists
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Collection<Renderable> objects = null; //Temporary until Cube has a getSomething method
		for(Renderable object : objects) {
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//game.update(delta); Update game logic
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Base(), screenWidth, screenHeight,false);
		container.start();
	}
}