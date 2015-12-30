package usgengine.game;

import usgengine.graphics.Window;

public class GameManager {

	private Game game;
	private Window window;

	private int fps, ups;
	private int targetUps = 60;

	private boolean running;

	public GameManager(Game game, int width, int height, boolean vsync, boolean fullscreen, boolean visible, boolean resizable) {
		this.game = game;
		this.window = new Window(game.getTitle(), width, height, vsync, fullscreen, visible, resizable);
	}
	
	public void init() {
		game.init(this);
	}
	
	public void enter() {
		game.enter(this);
	}
	
	public void update() {
		window.updateInput();
		game.update(this);
	}
	
	public void render() {
		window.clear();
		game.render(this);
		window.update();
	}
	
	public void leave() {
		game.leave(this);
	}
	
	public void start() {
		init();

		long lastTime = System.nanoTime();
		int frames = 0, updates = 0;
		double delta = 0.0;
		double ns = 1000000000.0 / targetUps;
		long timer = System.currentTimeMillis();
		running = true;

		while (true) {
			if (window.shouldClose() || !isRunning()) {
				shutdown();
				break;
			}
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				ups = updates;
				fps = frames;
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void shutdown() {
		leave();
		window.dispose();
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public Game getGame() {
		return game;
	}
	
	public Window getWindow() {
		return window;
	}
	
	public int getFrames() {
		return fps;
	}
	
	public int getUpdates() {
		return ups;
	}
	
	public int getTargetUpdates() {
		return targetUps;
	}
	
	public String getTitle() {
		return game.getTitle();
	}
	
}
