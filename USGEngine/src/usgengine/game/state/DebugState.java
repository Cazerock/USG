package usgengine.game.state;

import usgengine.game.GameManager;
import usgengine.game.state.State;
import usgengine.game.state.StateBasedGame;
import usgengine.input.Keyboard;

public class DebugState implements State {

	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameManager gm, StateBasedGame game) {
	}

	@Override
	public void enter(GameManager gm, StateBasedGame game) {
	}

	@Override
	public void update(GameManager gm, StateBasedGame game) {
		if(Keyboard.isPressed(Keyboard.KEY_SPACE)) {
			game.enterState(0);
		}
	}

	@Override
	public void render(GameManager gm, StateBasedGame game) {
	}

	@Override
	public void leave(GameManager gm, StateBasedGame game) {
	}
	
}