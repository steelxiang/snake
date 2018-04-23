package ̰����002;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SnakeFrame extends JFrame {
	Snake snake;
	Food food;
    boolean pause=false;
    int time=200;
    JLabel score=new JLabel("Score");
    JButton start=new JButton("START");
    JButton stop=new JButton("STOP");
    JButton exit=new JButton("EXIT");
    JButton restart=new JButton("RESTART");
    String soc="0";
    JButton button2=new JButton(soc);
    int count=0;
    JLabel label=new JLabel("ѡ���Ѷ�");
    String[] str= {"�߼�","�м�","����"};
    JComboBox menu=new JComboBox(str);
	public void eat() {

		int x = snake.head.getRow();
		int y = snake.head.getCol();
		int a = food.node.getRow();
		int b = food.node.getCol();
		if (x == a && y == b) {
			food = new Food();
			snake.addHead();
			count++;
			button2.setText(String.valueOf(count));
		} else
			return;
	}
	/**
	 * initalΪÿ����ť������ActionListener��KeyListener
	 * ���ֻ��ActionListener��ô�����ť֮�󣬷�������ʧЧ
	 */
	public void inital() {
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pause=true;
				
			}
			
		});
		menu.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(menu.getSelectedItem()=="�߼�") {
						time=30;
					}
					if(menu.getSelectedItem()=="�м�") {
						time=100;
					}
					if(menu.getSelectedItem()=="������") {
						time=300;
					}
				}
			}
			
		});
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pause=false;
				snake=new Snake();
				
			}
			
		});
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pause=false;
				
			}
			
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		start.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
		stop.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
		exit.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
		restart.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
	
	}

	public SnakeFrame() {

		this.setTitle("̰����");
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		});
		start.setBounds(800, 400, 160, 60);
		stop.setBounds(800, 450, 160, 60);
		restart.setBounds(800, 500, 160, 60);
	    exit.setBounds(800, 550, 160, 60);
		button2.setBounds(800, 200, 160, 80);
		score.setBounds(800, 150, 80, 80);
		menu.setBounds(875, 30, 80, 50);
		label.setBounds(800, 30, 80, 50);
		this.add(start);
		this.add(button2);
		this.add(score);
		this.add(stop);
		this.add(exit);
		this.add(restart);
		this.add(label);
		//menu.addItem("�߼�");
		//menu.addItem("�м�");
		//menu.addItem("����");
		this.add(menu);
		snake = new Snake();
		food = new Food();
		inital();
	}

	public void meetWall() {
		int x = snake.head.getRow();
		int y = snake.head.getCol();
		int a = food.node.getRow();
		int b = food.node.getCol();
		int h = snake.head.getDirection();
		// �����ͷ�����ϱ߽磬�����Ҹ���
		if (x == 2) {
			if (y < b && h != 3) {
				snake.head.setDirection(4);
			}
			if (y > b && h != 4) {
				snake.head.setDirection(3);
			}
			if(y==0||y==39) 	 {
				snake.head.setDirection(1);
			}
		}
		// �����ͷ�����±߽磬�����Ҹ���
		if (x == 39) {
			if (y < b && h != 3) {

				snake.head.setDirection(4);
			}
			if (y > b && h != 4) {
				snake.head.setDirection(3);
			}
			if(y==0||y==39) 	 {
				snake.head.setDirection(2);
			}
		}
		// �����ͷ������߽磬�����¸���
		if (y == 1) {
			if (x < a && h != 1) {
			}
			snake.head.setDirection(2);
			}
			if (x > a && h != 2) {
			snake.head.setDirection(1);
		}
			if(x==2||x==39) {
				snake.head.setDirection(4);
			}
		// �����ͷ�����ұ߽磬�����¸���
		if (y == 39) {
			if (x < a && h != 1) {
			}
			snake.head.setDirection(2);
			}
			if (x > a && h != 2) {
			snake.head.setDirection(1);

			}
			if(x==2||x==39) {
			snake.head.setDirection(3);
			}
	}

	public void dead() {
		int x = snake.head.getRow();
		int y = snake.head.getCol();
		boolean flag=intersection();
		if (x < 1 || x > 38 || y < 1 || y > 38) {
			pause=false;                                    //ֹͣˢ��
		JOptionPane.showMessageDialog(this, "GAMEOVER","information",1);//����ȷ�Ͽ�
		snake = new Snake();
		}
		if(flag) {
			pause=false;                                    //ֹͣˢ��
			JOptionPane.showMessageDialog(this, "GAMEOVER","information",1);//����ȷ�Ͽ�
			snake = new Snake();
		}

	}
	public boolean intersection() {
		Node node=snake.head.getNext();
		while(node!=null) {
			int x=node.getCol();
			int y=node.getRow()	;
			int a=snake.head.getCol();
			int b=snake.head.getRow();
			if(x==a&&y==b) {
				return true;
								}
			else {
			node=node.getNext();
								}
		
		}
		return false;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 20; i <= 800; i += 20) {   
			g.drawLine(0, i, 800, i);
			g.drawLine(i, 40, i, 800);
		}
		snake.draw(g);
		food.draw(g);
	}

}
