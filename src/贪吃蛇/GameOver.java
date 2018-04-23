package Ã∞≥‘…ﬂ;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class GameOver extends JDialog{
	
	    public GameOver() {
	    	//this.setVisible(true);
	    	this.setSize(300,200);
	    	this.setLocationRelativeTo(null);
	    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    	this.setTitle("Information");
	    	JLabel label=new JLabel();
	    	//label.setLocation(0, 50);
	    	this.add(label);
	    	
	    	label.setText("                                     GAME OVER");
	    }

}
