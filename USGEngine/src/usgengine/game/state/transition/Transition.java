package usgengine.game.state.transition;

import usgengine.game.GameManager;
import usgengine.game.state.State;
import usgengine.game.state.StateBasedGame;

public interface Transition {
	
	public void init(State current, State next);
	
	public void preRender(GameManager gm, StateBasedGame game);
	
	public void postRender(GameManager gm, StateBasedGame game);
	
	public void update(GameManager gm, StateBasedGame game);
	
	public boolean isComplete();

}
