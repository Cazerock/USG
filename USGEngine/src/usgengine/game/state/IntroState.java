package usgengine.game.state;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import usgengine.game.GameManager;
import usgengine.game.state.State;
import usgengine.game.state.StateBasedGame;
import usgengine.graphics.Color;
import usgengine.graphics.Cursor;
import usgengine.graphics.Texture;
import usgengine.graphics.shader.Shader;
import usgengine.input.Keyboard;
import usgengine.math.Matrix4f;

public class IntroState implements State {
	
	private Shader shader;
	private Texture texture;
	
	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void init(GameManager gm, StateBasedGame game) {
		gm.getWindow().setCursor(new Cursor(Texture.fromColor(Color.RED, 20, 20)));

		Matrix4f ortho = Matrix4f.orthographic(16.0f, -16.0f, 9.0f, -9.0f, -1.0f, 1.0f);
		
		shader = Shader.fromPath("res/shader/texvert.txt", "res/shader/texfrag.txt");
		shader.bind();
		shader.setUniformMat4f("pr_matrix", ortho);
		shader.setUniform1f("tex", 0);
		
		glActiveTexture(GL_TEXTURE0);
		texture = Texture.fromColor(Color.BLUE, 100, 100);
		texture.bind();
		
	}

	@Override
	public void enter(GameManager gm, StateBasedGame game) {
	}

	@Override
	public void update(GameManager gm, StateBasedGame game) {
		if (Keyboard.isPressed(Keyboard.KEY_SPACE)) {
			game.enterState(1);
		}
	}

	@Override
	public void render(GameManager gm, StateBasedGame game) {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(0, 1);
		glVertex2f(0, 4);
		glTexCoord2f(1, 1);
		glVertex2f(4, 4);
		glTexCoord2f(1, 0);
		glVertex2f(4, 0);
		glEnd();
	}

	@Override
	public void leave(GameManager gm, StateBasedGame game) {
	}

}