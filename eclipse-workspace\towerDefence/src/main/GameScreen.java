package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel{
	private Random random;
	private BufferedImage img;
	
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public GameScreen(BufferedImage img) {
		this.img = img;
		
		loadSprites();
		
		random = new Random();
	}
	private void loadSprites() {
		for(int y=0; y<3; y++) {
			for(int x=0; x<10; x++) {
				sprites.add(img.getSubimage(x*32, y*32, 32, 32));
			}
		}
//		sprites.add(img.getSubimage(0*32, 0*32, 32, 32));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		BufferedImage subImg = img.getSubimage(32*0, 32*1, 32, 32);
//		g.drawImage(img.getSubimage(32*0, 32*0, 32, 32), 0, 0, null);

		
//		for(int y=0; y<20; y++) {
//			for(int x=0; x<20; x++) {
//				g.setColor(getRndColor());
//				g.fillRect( x*32, y*32, 32, 32);	
//			}
//		}
		
//		int i=0;
//		for(int y=0; y<3; y++) {
//			for(int x=0; x<10; x++) {
//				g.drawImage(sprites.get(i++), x*32, 32*y, null);
//			}
//		}
		for(int y=0; y<20; y++) {
			for(int x=0; x<20; x++) {
				g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
			}
		}
		
	}
	private int getRndInt() {
		return random.nextInt(30);
	}
	private Color getRndColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r, g, b);
	}
}
