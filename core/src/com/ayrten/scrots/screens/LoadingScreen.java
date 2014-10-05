package com.ayrten.scrots.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LoadingScreen implements Screen 
{
	private ScrotsGame game;
	private Stage stage;
	
	public LoadingScreen(ScrotsGame game)
	{
		this.game = game;

		stage = new Stage();

		Label.LabelStyle style = new Label.LabelStyle();
		style.font = game.font_120;
		Label scrots = new Label("SCROTS", style);
		scrots.setCenterPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/3 * 2);
		
		style.font = game.font_32;
		Label ayrten = new Label("by Ayrten", style);
		ayrten.setCenterPosition(Gdx.graphics.getWidth()/2 + (Gdx.graphics.getWidth()/10), 
				Gdx.graphics.getHeight()/3 * 2 - scrots.getHeight());
		
		stage.addActor(scrots);
		stage.addActor(ayrten);
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();

		if(Gdx.input.isTouched())
		{
			game.setScreen(game.main_menu);
			this.dispose();
		}
	}
	
	@Override
	public void dispose() 
	{
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() 
	{
		
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}