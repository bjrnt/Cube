package core;

import game.Game;
import game.GameController;

import java.util.ArrayList;

import menu.Menu;
import menu.MenuItem;
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
	private Menu menu;
	private Game game;
	
	private Cube c;
	private Square s;
	Direction currentD = Direction.RIGHT;
	int ticker = 0;
	
	private Image background;
	
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
		// Game game = new Game(); For when the Game class exists
		
		background = new Image("data/bg.jpg");
		c = new Cube(10);
		s = c.getSquare(0, 0, 0);
		input = container.getInput();
		cc = new CubeController(c);
		
		game = new Game(c.getSquare(0, 0, 0));
		gc = new GameController(game);
		
		menu = new Menu(input);
		menu.enableMenuClick();
	}
	
	private void enableCubeInput() {
		ih = new InputHandler(input, cc, gc);
	}

	/**
	 * Renders the screen.
	 */
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		
		background.draw(0,0);
		
		if(menu.getActive()) {
			ArrayList<MenuItem> menuItems = menu.getMenuItems();
			for(int i = 0; i < menuItems.size(); i++) {
				menuItems.get(i).getImage().draw(menuItems.get(i).getX(), menuItems.get(i).getY());
			}
			return;
		}
		
		renderCube(g);
	}
	
	/**
	 * Renders the cube and its grid of lines. Only renders the three sides
	 * facing the viewer.
	 * 
	 * @param g The Graphics object that should be used to render.
	 */
	private void renderCube(Graphics g) {
		ticker++;
		s.setBackColor(new Color(ticker % 255, 255 - (ticker % 255),
				(ticker / 2) % 255));
		if (ticker % 100 == 0) {
			currentD = Direction.randomDirection();
		}
		Square temp = s.getNeighbor(currentD);
		if (temp != null) {
			s = temp;
		}

		MatrixTranslator mt = new MatrixTranslator(c.getRotX(), c.getRotY(), c.getRotZ());
		// A hot tip is to render the squares before the grid to have the grid
		// lines cover the squares nicely
		// rendering background squares
		renderManySquares(c.getSquares(mt), g, mt);

		// rendering arrows
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

	/**
	 * Renders a square to the screen
	 * 
	 * @param g
	 * @param mt
	 * @param s
	 */
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
		if(menu.getActive()) {
			return;
		}
		if(ih == null)
			enableCubeInput();
		
		cc.runAnimation();
		game.update(delta);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Base(),
				screenWidth, screenHeight, false);
		container.start();
	}
}