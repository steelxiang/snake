package Ã∞≥‘…ﬂ002;

public class Play {
	public static void main(String[] args) throws InterruptedException {
		SnakeFrame sf = new SnakeFrame();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if(sf.pause) {
					sf.repaint();
					}
					try {
						Thread.sleep(sf.time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		while (true) {
			
		sf.eat();
		sf.dead();
		//sf.meetWall();
		System.out.println("********");
		}

	}
}
