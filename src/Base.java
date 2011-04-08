import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Base extends BasicGame {

	public Base() {
		super("Cube3D");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		//Game game = new Game(); For when the Game class exists
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		//Get objects to render from cube
		//for each object: object.draw(object.x,object.y);
		//Get object to render from game (things that are not directly on the cube, for example score)
		//for each object: object.draw(object.x,object.y);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//game.update(delta); Update game logic
	}
	
	public static void main(String[] args) throws SlickException {
		System.out.println("java.library.path = " +
		System.getProperty("java.library.path"));
		System.out.println();
		System.out.println("java.ext.dirs = " +
		System.getProperty("java.ext.dirs"));
		System.out.println();
		System.out.println("java.class.path = " +
		System.getProperty("java.class.path"));
		System.out.println();
		AppGameContainer container = new AppGameContainer(new Base(), 800,600,false);
		container.start();
	}
}
