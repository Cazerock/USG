package usgengine.game;

public abstract class BasicGame implements Game {

	private GameManager manager;
	private String title;

	public BasicGame(GameManager manager, String title) {
		this.manager = manager;
		this.title = title;
	}

	@Override
	public abstract void init(GameManager gm);

	@Override
	public abstract void enter(GameManager gm);

	@Override
	public abstract void update(GameManager gm);

	@Override
	public abstract void render(GameManager gm);

	@Override
	public abstract void leave(GameManager gm);

	public String getTitle() {
		return title;
	}

	public GameManager getManager() {
		return manager;
	}

}
