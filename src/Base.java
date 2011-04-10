import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Base extends BasicGame {
	static private final int screenWidth = 800;
	static private final int screenHeight = 600;
	
	private Camera camera;
	private Translator translator;
	
	private Cube c;
	private float rotation=0;
	
	private ArrayList<Vector3D> vl;
	
	public Base() {
		super("Cube3D");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		camera = new Camera(new Vector3D(1000,0,0));
		translator = new Translator(camera);
		vl = new ArrayList<Vector3D>();
		
		vl.add(new Vector3D(50,-50,50));
		vl.add(new Vector3D(50,50,50));
		
		vl.add(new Vector3D(50,50,50));
		vl.add(new Vector3D(50,50,-50));
		
		vl.add(new Vector3D(50,50,-50));
		vl.add(new Vector3D(50,-50,-50));
		
		vl.add(new Vector3D(50,-50,-50));
		vl.add(new Vector3D(50,-50,50));
		
		vl.add(new Vector3D(50,-50,50));
		vl.add(new Vector3D(-50,-50,50));
		
		vl.add(new Vector3D(50,50,50));
		vl.add(new Vector3D(-50,50,50));
		
		vl.add(new Vector3D(50,50,-50));
		vl.add(new Vector3D(-50,50,-50));
		
		vl.add(new Vector3D(50,-50,-50));
		vl.add(new Vector3D(-50,-50,-50));
		
		vl.add(new Vector3D(-50,-50,50));
		vl.add(new Vector3D(-50,50,50));
		
		vl.add(new Vector3D(-50,50,50));
		vl.add(new Vector3D(-50,50,-50));
		
		vl.add(new Vector3D(-50,50,-50));
		vl.add(new Vector3D(-50,-50,-50));
		
		vl.add(new Vector3D(-50,-50,-50));
		vl.add(new Vector3D(-50,-50,50));
		//Game game = new Game(); For when the Game class exists
		
		c=new Cube(10);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		
//		//X vector is red
//		g.setColor(org.newdawn.slick.Color.red);
//		Vector2D trns = translator.translateTo2D(vl.get(0));
//		Vector2D trns2 = translator.translateTo2D(vl.get(1));
//		g.drawLine(400+trns.getX(), 300-trns.getY(), 400+trns2.getX(), 300-trns2.getY());
//		
//		//Y vector is green
//		g.setColor(org.newdawn.slick.Color.green);
//		trns = translator.translateTo2D(vl.get(2));
//		trns2 = translator.translateTo2D(vl.get(3));
//		g.drawLine(400+trns.getX(), 300-trns.getY(), 400+trns2.getX(), 300-trns2.getY());
//		
//		//Z vector is blue
//		g.setColor(org.newdawn.slick.Color.blue);
//		trns = translator.translateTo2D(vl.get(4));
//		trns2 = translator.translateTo2D(vl.get(5));
//		g.drawLine(400+trns.getX(), 300-trns.getY(), 400+trns2.getX(), 300-trns2.getY());
//		
//		g.setColor(org.newdawn.slick.Color.white);
//		for(int i = 0; i < vl.size(); i+=2) {
//			trns = translator.translateTo2D(vl.get(i));
//			trns2 = translator.translateTo2D(vl.get(i+1));
//			g.drawLine(400+trns.getX(), 300-trns.getY(), 400+trns2.getX(), 300-trns2.getY());
//		}
		g.setColor(Color.gray);
		renderCube(g);
	}
	/**
	 * Renders the cube and its grid of lines
	 * Only renders the three sides facing the viewer
	 * @param g
	 */
	private void renderCube(Graphics g){
		rotation+=0.01;
		MatrixTranslator mt=new MatrixTranslator(rotation,rotation,rotation);
		Vector2D trns,trns2;
		ArrayList<Vector3D[]> cubeGrid=c.getGrid(mt);
		for (int i = 0; i < cubeGrid.size(); i++) {
			trns = mt.screenTranslate(cubeGrid.get(i)[0]);
			trns2 = mt.screenTranslate(cubeGrid.get(i)[1]);
			g.drawLine(screenWidth/2+trns.getX(), screenHeight/2+trns.getY(), screenWidth/2+trns2.getX(), screenHeight/2+trns2.getY());
		}
	}
	private void renderSquare(Graphics g,MatrixTranslator mt,Square s){
		
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