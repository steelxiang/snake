package Ã∞≥‘…ﬂ;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	// Snake snake;
	Snake snake ;
	Food food ;
	GameOver over=new GameOver();
	public void eat() {
		int x = snake.head.getRow();
		int y = snake.head.getCol();
		int a = food.node.getRow();
		int b = food.node.getCol();
		if (x == a && y == b) {
			food = new Food();
			System.out.println(x);
			System.out.println(y);
			System.out.println(a);
			System.out.println(b);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			snake.addHead();
			System.out.println("########");
		} else
			return;
	}
	public SnakeFrame() {
		
		this.setTitle("Ã∞≥‘…ﬂ");
		this.setSize(800, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.add(over);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
		snake = new Snake();
		 food = new Food();
	}

	public void  meetWall() {
		int x = snake.head.getRow();
		int y = snake.head.getCol();
		int a = food.node.getRow();
		int b = food.node.getCol();
		int h=snake.head.getDirection();
		if(x==2) {
			if(y<b&&h!=3) {
				
				snake.head.setDirection(4);
			}if(y>b&&h!=4) {
				snake.head.setDirection(3);
			}
			}
	    if(x==39) {
	    	if(y<b&&h!=3) {
				snake.head.setDirection(4);
			}if(y>b&&h!=4) {
				snake.head.setDirection(3);
			}
			}
	    if(y==0) {
			if(x<a&&h!=1) {
				snake.head.setDirection(2);
			}if(x>a&&h!=2) {
				snake.head.setDirection(1);
			}
			}
	    if(y==39) {
	    	if(x<a&&h!=1) {
				snake.head.setDirection(2);
			}if(x>a&&h!=2) {
				snake.head.setDirection(1);
			}
	  
			
	    }
	}
	

	public void dead() {
		int x = snake.head.getRow();
		int y = snake.head.getCol();
		if(x<1||x>40||y<1||y>40) {
			over.setVisible(true);
			try {
				Thread.sleep(10000000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 20; i <= 780; i += 20) {
			g.drawLine(0, i, 800, i);
			g.drawLine(i, 40, i, 800);
		}
		snake.draw(g);
		food.draw(g);
	}

	

}
