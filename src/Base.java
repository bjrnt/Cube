import java.util.ArrayList;

import javax.swing.plaf.basic.BasicLookAndFeel;

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
	private Square s;
	Direction currentD=Direction.RIGHT;
	int ticker=0;
	
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
		
		c=new Cube(30);
		s=c.getSquare(0, 4, 5);
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
		//s=c.getSquare(5, 9, 3);
//		s.setBackColor(Color.magenta);
//		s=s.getNeighbor(Direction.RIGHT);
//		s.setBackColor(Color.yellow);
//		s=s.getNeighbor(Direction.LEFT).getNeighbor(Direction.DOWN);
//		s.setBackColor(Color.pink);
//		s.getNeighbor(Direction.RIGHT).setBackColor(Color.red);
		renderCube(g);
	}
	/**
	 * Renders the cube and its grid of lines
	 * Only renders the three sides facing the viewer
	 * @param g
	 */
	private void renderCube(Graphics g){
		rotation+=0.01;
		ticker++;
		s.setBackColor(new Color(ticker%255, 255-(ticker%255), (ticker/2)%255));
		if (ticker%100==0) {
			currentD=Direction.randomDirection();
		}
		Square temp=s.getNeighbor(currentD);
		if (temp!=null) {
			s=temp;
		}
		
		MatrixTranslator mt=new MatrixTranslator(rotation,rotation,2);
		//A hot tip is to render the squares before the grid to have the grid lines cover the squares nicely
		//rendering background squares
		renderManySquares(c.getSquares(mt), g, mt);
		
		//rendering arrows
		drawLines(g, mt, c.getArrows(mt), Color.red);
		
		//Rendering grid
		
		drawLines(g, mt,c.getGrid(mt),Color.lightGray);
		
	}

	private void drawLines(Graphics g, MatrixTranslator mt,ArrayList<Vector3D[]> points, Color c) {
		g.setColor(c);
		Vector2D trns,trns2;
		int l=points.size();
		for (int i = 0; i < l; i++) {
			trns = mt.screenTranslate(points.get(i)[0]);
			trns2 = mt.screenTranslate(points.get(i)[1]);
			g.drawLine(trns.getX(),trns.getY(),trns2.getX(), trns2.getY());
		}
	}
	/**
	 * Renders a square to the screen
	 * @param g
	 * @param mt
	 * @param s
	 */
	private void renderSquare(Graphics g,MatrixTranslator mt,Square s){
		g.setColor(s.getBackColor());
		g.fill(mt.translateSquare(s));
	}
	
	private void renderManySquares(ArrayList<Square> squares,Graphics g,MatrixTranslator mt){
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i)!=null) {
				renderSquare(g, mt, squares.get(i));
			}
			
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