package Model;

import java.awt.EventQueue;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Maze m=new Maze();
			View window = new View(m);
			while(m.check()) {
				m.run();
				window.fresh();
				Thread.sleep(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
