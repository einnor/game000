package com.einnor.game000;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameActivity extends BaseGameActivity {

	Scene scene;
	protected static final int CAMERA_WIDTH = 720;
	protected static final int CAMERA_HEIGHT = 480;
	BitmapTextureAtlas playerTexture;
	ITextureRegion playerTextureRegion;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		Camera mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions options = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(
						CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);

		return options;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		// TODO Auto-generated method stub
		loadGfx();

		// The callback after loading up all our resources
		pOnCreateResourcesCallback.onCreateResourcesFinished();

	}

	private void loadGfx() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

		// Width and height has to be to the power of 2 i.e 2^x
		playerTexture = new BitmapTextureAtlas(getTextureManager(), 64, 64);
		playerTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(playerTexture, this, "player.png", 0, 0);
		playerTexture.load();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		// TODO Auto-generated method stub
		this.scene = new Scene();
		this.scene.setBackground(new Background(0, 125, 58));

		// The callback after the scene has been created
		pOnCreateSceneCallback.onCreateSceneFinished(this.scene);

	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		// TODO Auto-generated method stub
		// Setup a sprite
		Sprite sPlayer = new Sprite(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2,
				playerTextureRegion, this.mEngine.getVertexBufferObjectManager());
		sPlayer.setRotation(45.0f);
		this.scene.attachChild(sPlayer);

		// The callback after the scene has been loaded, so as to populate it
		pOnPopulateSceneCallback.onPopulateSceneFinished();

	}

}
