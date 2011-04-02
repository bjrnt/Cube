public class Game {
	private Renderer renderer;
	private static final int TIME_STEP = 30;
	
	public Game() {
	}
	
	public void run() {
		boolean running = true;
		long lastTime = System.currentTimeMillis();
		long accumulatedTime = 0;
		
		while(running) {
			long currentTime = System.currentTimeMillis();
			accumulatedTime += currentTime - lastTime;
			lastTime = currentTime;
			
			while(accumulatedTime > Game.TIME_STEP) {
				accumulatedTime -= Game.TIME_STEP;
				update(Game.TIME_STEP);
			}
			
			render();
		}
	}
	
	private void render() {
		renderer.render();
	}
	
	private void update(double dt) {
		dt /= 1000;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game g = new Game();
		System.exit(0);
	}
}
