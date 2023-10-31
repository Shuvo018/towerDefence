package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private Game game;
	public MyMouseListener(Game game) {
		this.game = game;
	}
	@Override
	public void mouseDragged(MouseEvent e) {

		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mouseDragged(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mouseDragged(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mouseDragged(e.getX(), e.getY());
			break;
			default:
				break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mouseMoved(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mouseMoved(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mouseMoved(e.getX(), e.getY());
			break;
			default:
				break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		if(e.getButton() == MouseEvent.BUTTON1)
//			System.out.println("left button");
//		else if(e.getButton() == MouseEvent.BUTTON2)
//			System.out.println("middle button");
//		else if(e.getButton() == MouseEvent.BUTTON3)
//			System.out.println("right button");
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch(GameStates.gameState) {
			case MENU:
//				System.out.println("Mouse pos : "+e.getX()+" : "+e.getY());
				game.getMenu().mouseClicked(e.getX(),e.getY());
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(e.getX(),e.getY());
				break;
			case SETTINGS:
				game.getSettings().mouseClicked(e.getX(),e.getY());
				break;
				default:
					break;
			}
		}
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("mouse exited");
	}

	@Override
	public void mousePressed(MouseEvent e) {

		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mousePressed(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mousePressed(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mousePressed(e.getX(), e.getY());
			break;
			default:
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mouseReleased(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().mouseReleased(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().mouseReleased(e.getX(), e.getY());
			break;
			default:
				break;
		}
	}

}
