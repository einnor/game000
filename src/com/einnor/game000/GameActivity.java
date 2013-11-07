package com.einnor.game000;

import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameActivity extends BaseGameActivity {
	
	Scene scene;
	protected static final int CAMERA_WIDTH = 720;
	protected static final int CAMERA_HEIGHT = 480;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		//The callback after loading up all our resources
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		// TODO Auto-generated method stub
		this.scene = new Scene();
		
		//The callback after the scene has been created
		pOnCreateSceneCallback.onCreateSceneFinished(this.scene);
		
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		// TODO Auto-generated method stub
		
		
		//The callback after the scene has been loaded, so as to populate it
		pOnPopulateSceneCallback.onPopulateSceneFinished();
		
	}

}
