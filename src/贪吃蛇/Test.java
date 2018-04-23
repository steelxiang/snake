package Ã∞≥‘…ﬂ;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Test extends JFrame{
       int x=300;
       int y=300;
       public Test() {
    	  this.setTitle("Snake");
    	  this.setSize(800, 800);
    	  this.setVisible(true);
    	  this.setDefaultCloseOperation(3);
    	  this.setLocationRelativeTo(null);
    	  this.addKeyListener(new KeyAdapter() {
    		  public void keyPressed(KeyEvent e) {
    			 int key=e.getKeyCode();
    			 switch(key) {
    			 case KeyEvent.VK_UP:
    				 y=y-20;
    				 
    				// repaint();
    				 break;
    			 case KeyEvent.VK_DOWN:
    				 y=y+20;
    				// repaint();
    				 break;
    			 case KeyEvent.VK_LEFT:
    				 x=x-20;
    				// repaint();
    				 break;
    			 case KeyEvent.VK_RIGHT:
    				 x=x+20;
    				// repaint();
    				 break;
    			 }
    		  }
    		  
    	  });
    	  
       }
       public void paint(Graphics g) {
    	   super.paint(g);
    	   g.fillRect(x, y, 30, 30);
    	   
    	     	   
       }
     
    	  
    	   
   
    	  
    	  public static void main(String[] args) {
    		  Test test=new Test();
    		  while(true) {
        		  test.repaint();
        		  try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	   }

    		//update();
    	  }
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	   
	
	
}
