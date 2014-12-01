package com.ayrten.scrots.screens;

import com.ayrten.scrots.dots.Dot;
import com.ayrten.scrots.manager.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TutorialScreen extends ScrotsScreen
{	
	public TutorialScreen(Screen bscreen)
	{
		super(bscreen, false);
		createBackLabel();
		
		Table table = new Table(Assets.skin);
		table.setFillParent(true);
		table.left().top();
		table.padLeft(back.getWidth()/5).padRight(back.getWidth()/5);
		
		Label intent = new Label("", Assets.style_font_32_orange);
		intent.setWrap(true);
		intent.setText("The goal of the game is pop all the greens on screen as fast"
				+ " as possible! When all green dots are popped, you gain a point and"
				+ " the difficulty level increases. If time runs out or you popped a red"
				+ " dot, then GAME OVER! Below are the type of dots you'll be encountering:");
		
		Dot greenDot = new Dot(Assets.greenDot) {
			@Override
			public void draw(Batch batch, float alpha) {
				batch.draw(this.dot, getX(), getY(), getWidth(), getHeight());
			}
		};
		Dot redDot = new Dot(Assets.redDot);
		Dot blueDot = new Dot(Assets.blueDot);
		Dot babyBlueDot = new Dot(Assets.babyBlueDot);
		
		Label greenDesc = new Label("", Assets.style_font_32_orange);
		greenDesc.setWrap(true);
		greenDesc.setText("Requires popping in order to advance");
		
		Label redDesc = new Label("", Assets.style_font_32_orange);
		redDesc.setWrap(true);
		redDesc.setText("Immediate GAME OVER!");
		
		Label blueDesc = new Label("", Assets.style_font_32_orange);
		blueDesc.setWrap(true);
		blueDesc.setText("Decreases time limit by 5 seconds so BE CAREFUL!");
		
		Label babyBlueDesc = new Label("", Assets.style_font_32_orange);
		babyBlueDesc.setWrap(true);
		babyBlueDesc.setText("Increased time limit by 1 second");
		
		Table innerTable = new Table(Assets.skin);
		innerTable.left().top();
		innerTable.add(greenDot);
		innerTable.add(greenDesc).width(Gdx.graphics.getWidth()/2 - back.getWidth()/5);
		innerTable.row();
		innerTable.add(redDot);
		innerTable.add(redDesc).width(Gdx.graphics.getWidth()/2 - back.getWidth()/5);
		innerTable.row();
		innerTable.add(blueDot);
		innerTable.add(blueDesc).width(Gdx.graphics.getWidth()/2 - back.getWidth()/5);
		innerTable.row();
		innerTable.add(babyBlueDot);
		innerTable.add(babyBlueDesc).width(Gdx.graphics.getWidth()/2 - back.getWidth()/5);
		
		table.add(back).left();
		table.row();
		table.add(intent).width(Gdx.graphics.getWidth() - back.getWidth()/5);
		table.row();
		table.add("whatever").height(back.getStyle().font.getLineHeight());
		table.row();
		table.add(innerTable);
		
		ScrollPane scroll_view = new ScrollPane(table);
		scroll_view.setFillParent(true);
		scroll_view.setFlickScroll(true);
		scroll_view.updateVisualScroll();
		
		setupStage();
		stage.addActor(scroll_view);
	}
}
