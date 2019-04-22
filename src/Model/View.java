package Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.util.Vector;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


//this is just a windows to show the code run not in console.
//never care about it.
public class View {

	private JFrame frmMize;
	private Maze m;
	private Vector<JLabel> blocks=new Vector<JLabel>();
	
	private ImageIcon nothing=new ImageIcon(View.class.getResource("/img/null.png"));
	private ImageIcon wall=new ImageIcon(View.class.getResource("/img/wall.png"));
	private ImageIcon gold=new ImageIcon(View.class.getResource("/img/gold.png"));
	private ImageIcon player=new ImageIcon(View.class.getResource("/img/player.png"));

	/**
	 * Create the application.
	 */
	public View(Maze m) {
		this.m=m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMize = new JFrame();
		frmMize.setResizable(false);
		frmMize.setTitle("Mize");
		frmMize.setBounds(100, 100, 500, 500);
		frmMize.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMize.getContentPane().setLayout(new GridLayout(10,10,0,0));
		for(int i=0;i<100;i++) {
			blocks.add(new JLabel());
			switch(m.getNum(i)) {
				case 0:blocks.get(i).setIcon(nothing);break;
				case 1:blocks.get(i).setIcon(wall);break;
				case 2:blocks.get(i).setIcon(gold);break;
				case 3:blocks.get(i).setIcon(player);break;
			}
			frmMize.getContentPane().add(blocks.get(i));
		}
		frmMize.setVisible(true);
	}
	
	public void fresh() {
		for(int i=0;i<100;i++) {
			switch(m.getNum(i)) {
				case 0:blocks.get(i).setIcon(nothing);break;
				case 1:blocks.get(i).setIcon(wall);break;
				case 2:blocks.get(i).setIcon(gold);break;
				case 3:blocks.get(i).setIcon(player);break;
			}
		}
	}
	
}
