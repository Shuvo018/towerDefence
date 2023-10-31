package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameStates;
import static main.GameStates.*;

public class KeyboardListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_A)
			GameStates.gameState = MENU;
		else if(e.getKeyCode() == KeyEvent.VK_S)
			GameStates.gameState = PLAYING;
		else if(e.getKeyCode() == KeyEvent.VK_D)
			GameStates.gameState = SETTINGS;
		
//		System.out.println(e.getKeyCode()+"  "+e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
