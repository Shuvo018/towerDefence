package main;
import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

public class Game extends JFrame implements Runnable {
	public static GameScreen gameScreen;
	
	private Thread gameThread;
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	

	// classes
	private Render render;
	private Menu menu;
	private Playing playing;
	private Settings settings;
	
	Game() {
		
		initClasses();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		add(gameScreen);
		pack();
		
		setVisible(true);
	}
	private void initClasses() {
		render = new Render(this);
		gameScreen = new GameScreen(this);
		menu = new Menu(this);
		playing = new Playing(this);
		settings = new Settings(this);
	}
	
	public Menu getMenu() {
		return menu;
	}
	public Playing getPlaying() {
		return playing;
	}
	public Settings getSettings() {
		return settings;
	}

	private void start() {
		gameThread = new Thread(this) {
			
		};
		gameThread.start();
	}

	private void updateGame() {
		
//		System.out.println("Game update");

	}

	public static void main(String args[]) {
		Game game = new Game();
		game.gameScreen.initInputs();
		game.start();
	}

	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		
		int frames = 0;
		int updates = 0;
		
		
		while (true) {
			long now = System.nanoTime();
			// Render
			if (now - lastFrame >= timePerFrame) {
				lastFrame = now;
				repaint();
				frames++;
			}
			
			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}
			
			if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS : "+frames+" | UPS : "+updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}

		
		// Checking FPS OR UPS
	}
	public Render getRender() {
		return render;
	}
}
