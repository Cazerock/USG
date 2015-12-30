package usgengine.game.state;

import usgengine.game.GameManager;

public interface State {

	public int getID();

	public void init(GameManager gm, StateBasedGame game);

	public void enter(GameManager gm, StateBasedGame game);

	public void update(GameManager gm, StateBasedGame game);

	public void render(GameManager gm, StateBasedGame game);

	public void leave(GameManager gm, StateBasedGame game);

}
