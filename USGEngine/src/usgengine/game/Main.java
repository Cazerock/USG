package usgengine.game;

import usgengine.game.state.DebugState;
import usgengine.game.state.IntroState;
import usgengine.game.GameManager;
import usgengine.game.state.StateBasedGame;
import usgengine.input.Keyboard;

public class Main extends StateBasedGame {
	
	private static GameManager manager;

	public Main(String title) {
		super(manager, title);
	}

	public static void main(String[] args) {
		manager = new GameManager(new Main("USG"), 1280, 720, false, false, true, true);
		manager.start();
	}

	@Override
	public void initStatesList() {
		addState(new IntroState());
		addState(new DebugState());
	}

}
