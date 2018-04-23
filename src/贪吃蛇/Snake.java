package 贪吃蛇;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * 1、头结点
2、尾结点
3、构造函数
3、draw方法
 * @author xiang
 *
 */
public class Snake   {
      Node head;
      Node tail;
      int size;
      Node iniNide=new Node(3,4,4);
      public Snake() {
    	  head=iniNide;
    	  tail=iniNide;
    	  size++;
    	 // this.sf=sf;
    	  
      }
      
	public void draw(Graphics g) {
		if(head==null) {
			return;
			
		}
		move();
		for(Node node=head;node!=null;node=node.getNext()) {
			node.draw(g);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key= e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
		    if(head.getDirection()!=2) {
		    	head.setDirection(1);
		    }
		    break;
		case KeyEvent.VK_DOWN:
		    if(head.getDirection()!=1) {
		    	head.setDirection(2);
		    }
		    break;
		case KeyEvent.VK_LEFT:
		    if(head.getDirection()!=4) {
		    	head.setDirection(3);
		    }
		    break;
		case KeyEvent.VK_RIGHT:
		    if(head.getDirection()!=3) {
		    	head.setDirection(4 );
		    }
		    break;
		}
		
	}
	
	public void move() {
		addHead();
		deleteTail();
	}

	private void deleteTail() {
		  Node node=tail.getPre();
		  tail.setNext(null);
		  tail=null;
		  tail=node;
	}

	public void addHead() {
		Node node=null;
		int x=head.getRow();
		int y=head.getCol();
		switch(head.getDirection()) {
		case(1) :
			node=new Node(x-1,y,1);
		break;
		case(2) :
			node=new Node(x+1,y,2);
		break;
		case(3) :
			node=new Node(x,y-1,3);
		break;
		case(4) :
			node=new Node(x,y+1,4);
		break;
		
		}
		head.setPre(node);
		node.setNext(head);
		head=node;
	}
	
}





















