package Ã∞≥‘…ﬂ;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {
	 Random ran = new Random();
	 int x = ran.nextInt(30) + 5;
	 int y = ran.nextInt(30) +5;
	 Node node = new Node(x, y);
	public Food() {
		this.node = new Node(x, y);
	}
	
	
	public void draw(Graphics g) {
		node.draw(g);

	}

}
