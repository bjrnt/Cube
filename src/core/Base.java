package core;

import game.Game;
import game.GameController;
import game.Level;

import java.util.ArrayList;

import sun.tools.jar.Main;
import ui.UI;
import ui.UIButton;
import objectTypes.Vector2D;
import objectTypes.Vector3D;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import cube.Cube;
import cube.CubeController;
import cube.Direction;
import cube.Square;

/**
 * The Base class contains the most fundamental functions for the program to be able to run.
 * For example rendering, updating game logic, etc.
 * 
 * @author Bjorn Tegelund, Johan Wikstrom
 */
public class Base extends BasicGame {
	private final static int screenWidth = 800;
	private final static int screenHeight = 600;

	private Input input;
	private InputHandler ih;
	private CubeController cc;
	private GameController gc;
	private UI ui;
	private Game game;
	
	private Cube c;
	private int currentLevel=0;
	Direction currentD = Direction.RIGHT;
	
	
	/**
	 * Creates a new game Base.
	 * The String sent to the superclass will be the title of the game window.
	 */
	public Base() {
		super("Cube3D");
	}

	/**
	 * Initializes objects, etc. This is done first in the game.
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		

//		c = new Cube(10);
//		c.getSquare(0, 2, 4).setEndSquare(Color.green);
//		c.getSquare(0, 6, 9).setEndSquare(Color.green);
//		c.getSquare(0, 5, 5).makeIntraversable();
//		c.getSquare(1, 3, 4).setEndSquare(Color.blue);
//		c.getSquare(0, 7, 0).setEndSquare(Color.blue);
		game = new Game();
		c=game.getCube();
		input = container.getInput();
		cc = new CubeController(c);
		
		
		gc = new GameController(game,c);

		
		ui = new UI(input, gc);
		ui.loadMenuButtons();
		ui.enableClick();
	}
	
	/**
	 * Enables the use of the keyboard to control the rotation of the Cube and the selected square.
	 */
	private void enableCubeInput() {
		ih = new InputHandler(input, cc, gc);
	}

	/**
	 * Renders the screen.
	 */
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		
		//background.draw(0,0);
		
		if(ui.getMenuActive()) {
			renderUI();
			return;
		}
		
		renderCube(g);
		renderUI();

	}
	
	/**
	 * Renders all the currently active buttons in the UI.
	 */
	private void renderUI() {
		ArrayList<UIButton> buttons = ui.getButtons();
		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).getImage().draw(buttons.get(i).getX(), buttons.get(i).getY());
		}
	}
	
	/**
	 * Renders the cube and its grid of lines. Only renders the three sides
	 * facing the viewer.
	 * 
	 * @param g The Graphics object that should be used to render.
	 */
	private void renderCube(Graphics g) {
		
		MatrixTranslator mt = new MatrixTranslator(c.getRotX(), c.getRotY(), c.getRotZ());
		// A hot tip is to render the squares before the grid to have the grid
		// lines cover the squares nicely
		// rendering background squares
		renderManySquares(c.getSquares(mt), g, mt);

		// rendering arrows
		if(ih != null)
			if(ih.usingPrimaryKeySet())
				drawLines(g, mt, c.getArrows(mt), Color.red);

		// Rendering grid
		drawLines(g, mt, c.getGrid(mt), Color.lightGray);
		
	}

	private void drawLines(Graphics g, MatrixTranslator mt,
			ArrayList<Vector3D[]> points, Color c) {
		g.setColor(c);
		Vector2D trns, trns2;
		int l = points.size();
		for (int i = 0; i < l; i++) {
			trns = mt.screenTranslate(points.get(i)[0]);
			trns2 = mt.screenTranslate(points.get(i)[1]);
			g.drawLine(trns.getX(), trns.getY(), trns2.getX(), trns2.getY());
		}
	}

	private void renderSquare(Graphics g, MatrixTranslator mt, Square s) {
		g.setColor(s.getBackColor());
		g.fill(mt.translateSquare(s));
	}

	private void renderManySquares(ArrayList<Square> squares, Graphics g,
			MatrixTranslator mt) {
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i) != null) {
				renderSquare(g, mt, squares.get(i));
			}

		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if (c!=game.getCube()) {
			c=game.getCube();
			cc.switchCube(c);
			gc.switchCube(c);
		}
		if(ui.getMenuActive()) {
			return;
		}
		if(ih == null) {
			enableCubeInput();
			ui.loadIngameButtons();
		}
		
		cc.runAnimations(delta);
		game.update(delta);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Base(),
				screenWidth, screenHeight, false);
		container.start();
	}
	
}