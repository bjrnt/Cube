import java.awt.Color;
import java.util.ArrayList;
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
	private Translator translator;
	
	private ArrayList<Vector3D> vl;
	
	public Base() {
		super("Cube3D");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		camera = new Camera(new Vector3D(500,0,0), 0,0,0);
		translator = new Translator(camera);
		vl = new ArrayList<Vector3D>();
		vl.add(new Vector3D(0,0,0));
		vl.add(new Vector3D(150,0,0));
		vl.add(new Vector3D(0,0,0));
		vl.add(new Vector3D(0,150,0));
		vl.add(new Vector3D(0,0,0));
		vl.add(new Vector3D(0,0,150));

		//Game game = new Game(); For when the Game class exists
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(org.newdawn.slick.Color.red);
		for(int i = 0; i < vl.size(); i+=2) {
			Vector2D trns = translator.translateTo2D(vl.get(i));
			Vector2D trns2 = translator.translateTo2D(vl.get(i+1));
			g.drawLine(400+trns.getX(), 300-trns.getY(), 400+trns2.getX(), 300-trns2.getY());
		}
		camera.rotationY += Math.PI/1000;
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