package usgengine.game;

public interface Game {	
	
	public void init(GameManager gm);
	
	public void enter(GameManager gm);
	
	public void update(GameManager gm);
	
	public void render(GameManager gm);
	
	public void leave(GameManager gm);
	
	public String getTitle();
	
}
