package com.ayrten.scrots.screens;

import com.ayrten.scrots.manager.Assets;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OthersScreen extends ScrotsScreen
{
	protected Table table;
	
	// Labels
//	protected Label options;
//	protected Label contact_us;
	protected Label tutorial;
	protected Label credits;
	
	// Screens
	protected TutorialScreen 	tutorial_screen;
	protected CreditsScreen		credits_screen;
	
	public OthersScreen(Screen bscreen)
	{
		super(bscreen, true);
		
		table = new Table(Assets.skin);
		table.setFillParent(true);
		
		tutorial_screen = new TutorialScreen(this);
		credits_screen  = new CreditsScreen(this);
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = Assets.font_64;
		labelStyle.fontColor = Assets.ORANGE;
		
		tutorial = new Label("Tutorial", labelStyle);
		tutorial.setBounds(tutorial.getX(), tutorial.getY(), tutorial.getWidth(), tutorial.getHeight());
		tutorial.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setActorsTouchable(Touchable.disabled);
				if(Assets.prefs.getBoolean("sound_effs", true))
					Assets.button_pop.play();
				tutorial_screen.setBackScreen(Assets.game.getScreen());
				Assets.game.setScreen(tutorial_screen);
			}
		});
				
		credits = new Label("Credits", labelStyle);
		credits.setBounds(credits.getX(), credits.getY(), credits.getWidth(), credits.getHeight());
		credits.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setActorsTouchable(Touchable.disabled);
				if(Assets.prefs.getBoolean("sound_effs", true))
					Assets.button_pop.play();
				Assets.game.setScreen(credits_screen);
			}
		});
		
		table.add(tutorial);
		table.row();
		table.add(credits);
		
		setupStage();
		stage.addActor(table);
	}
	
	@Override
	public void addActors() {
		actors.add(tutorial);
		actors.add(credits);
		super.addActors();
	}
}
