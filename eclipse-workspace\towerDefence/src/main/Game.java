package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame{
	public static GameScreen gameScreen;
	private BufferedImage img;
	Game(){
		importImg();
		
		System.out.print("hello game window");
		setSize(400, 400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		gameScreen = new GameScreen(img);
		add(gameScreen);
		
	}
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");
		try {
			img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Game game = new Game();
	}
}
