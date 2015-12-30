package usgengine.game.state.transition;

import usgengine.game.GameManager;
import usgengine.game.state.State;
import usgengine.game.state.StateBasedGame;

public class BlankTransition implements Transition {

	@Override
	public void init(State current, State next) {		
	}

	@Override
	public void preRender(GameManager gm, StateBasedGame game) {		
	}

	@Override
	public void postRender(GameManager gm, StateBasedGame game) {		
	}

	@Override
	public void update(GameManager gm, StateBasedGame game) {		
	}

	@Override
	public boolean isComplete() {
		return true;
	}

}
