package 贪吃蛇;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 1、位置
2、大小，即长度、宽度
3、方向
4、构造方法
5、draw方法
 * @author xiang
 *
 */
public class Node {
      
	private int row;
	private int col;
	private int direction;
	private Node next;
	private Node pre;
	public Node(int row,int col) {
		this.row=row;
		this.col=col;
	}
	
	public Node(int row,int col,int direction) {
		this.row=row;
		this.col=col;
		this.direction=direction;
		
	}
	
	public void draw(Graphics g) {
		g.fillRect(20*col, 20*row, 20, 20);
		g.setColor(Color.blue);
	}
	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPre() {
		return pre;
	}

	public void setPre(Node pre) {
		this.pre = pre;
	}
	
	
}

















