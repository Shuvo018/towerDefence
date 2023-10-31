package scenes;

import java.awt.Color;
import java.awt.Graphics;

import helps.LevelBuild;
import helps.LoadSave;
import main.Game;
import managers.TileManager;
import objects.Tile;
import ui.BottomBar;

public class Playing extends GameScene implements SceneMethods {

	private int[][] lvl;
	private static TileManager tileManager;
	private Tile selectedTile;
	private boolean drawSelect;
	private BottomBar bottomBar;

	private int mouseX, mouseY;
	private int lastTileX, lastTileY, lastTileId;

	public Playing(Game game) {
		super(game);

		lvl = LevelBuild.getLevelData();
		tileManager = new TileManager();
		bottomBar = new BottomBar(0, 640, 640, 100, this);
		
		LoadSave.CreateFile();
//		LoadSave.WriteToFile();
//		LoadSave.ReadFromFile();
		
//		createDefaultLevel();
	}

	private void createDefaultLevel() {
		int[] arr = new int[400];
		for(int i=0; i<arr.length; i++)
			arr[i] = i;
		LoadSave.CreateLevel("new_level", arr);
	}

	@Override
	public void render(Graphics g) {

		for (int y = 0; y < lvl.length; y++) {
			for (int x = 0; x < lvl[y].length; x++) {
				int id = lvl[y][x];
				g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
			}
		}
		bottomBar.draw(g);
		drawSelectedTile(g);
	}

	private void drawSelectedTile(Graphics g) {
		if (selectedTile != null && drawSelect) {
			g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
		}
	}

	public void setSelectedTile(Tile tile) {
		this.selectedTile = tile;
	}

	public static TileManager getTileManager() {
		return tileManager;
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (y >= 640)
			bottomBar.mouseClicked(x, y);
		else {
			changeTile(mouseX, mouseY);
		}
	}

	private void changeTile(int x, int y) {

		if (selectedTile != null) {
			// System.out.println("change tile x: "+x/32+" y: "+y/32);
			int tileX = x / 32;
			int tileY = y / 32;

		if(lastTileX == tileX && lastTileY == lastTileX 
				&& lastTileId == selectedTile.getId())
			return;
			lastTileX = tileX;
			lastTileY = tileY;
			lastTileId = selectedTile.getId();

			lvl[tileY][tileX] = selectedTile.getId();

			// example
			// x = 64, y = 64
			// we need coordinates(index) x/32 = 2, y/32 = 2 ;
		}

	}

	@Override
	public void mouseMoved(int x, int y) {
//		System.out.println("mouse pos : "+x+" : "+y);
		if (y >= 640) {
			bottomBar.mouseMoved(x, y);
			drawSelect = false;
		} else {
			drawSelect = true;
			mouseX = (x / 32) * 32; // 0*32, 1*32, 2*32
			mouseY = (y / 32) * 32; // 0*32, 1*32, 2*32
//			if (selectedTile != null)
//				System.out.println("mouse move x: " + x + " y: " + y + " = div x: " + (x / 32)*32 + " y: " + (y / 32)*32);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		if (y >= 640)
			bottomBar.mousePressed(x, y);
	}

	@Override
	public void mouseReleased(int x, int y) {
		bottomBar.mouseReleased(x, y);
	}

	@Override
	public void mouseDragged(int x, int y) {
		if (y >= 640) {

		} else {
			changeTile(x, y);
		}
	}

}
