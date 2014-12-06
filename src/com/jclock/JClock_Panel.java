package com.jclock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JClock_Panel extends JPanel {

	static JLabel timeLabel;	
	Date now = new Date();
	
	Point p;
	
	JClock_Panel() {addMouseListener(mkMouseAdapter());
		setLayout(null);
		setBounds(JClock.main.getBounds());
		setBackground(new Color(0,0,0,0));
		setOpaque(false);
		
		addMouseMotionListener(mkMouseAdapter());
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {				
				super.keyReleased(e);
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}			
		});
		requestFocus();

		timeLabel = new JLabel("00:00pm");
		timeLabel.setBounds(1, 0, getWidth(),getHeight());
		timeLabel.setFont (timeLabel.getFont ().deriveFont (60f));//change font size
		timeLabel.setBackground(new Color(0,0,0,0));
		timeLabel.setOpaque(false);
		add(timeLabel);
	
		new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true){
					try{
						timeLabel.setText(Options.clockStyle.format(now));
                        timeLabel.setForeground(Options.color);
						repaint();
						Thread.sleep(10);
					}catch(Exception e){}
				}
			}
		}).start();
	}//..
	
	protected MouseAdapter mkMouseAdapter() {
		return new MouseAdapter() {						
			
			@Override
			public void mousePressed(MouseEvent e) {				
				super.mousePressed(e);
				p = e.getPoint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getButton() == MouseEvent.BUTTON3){
					JClock.menu.show(e.getComponent(),e.getX(),e.getY());
					
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {	
				super.mouseDragged(e);
				Point np = e.getLocationOnScreen();
				if(JClock.menu.options.isMoveable){
					JClock.main.setLocation(np.x-p.x,np.y-p.y);
				}
			}			
		};
	}//..

	@Override
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		//JOptionPane.showMessageDialog(null, "r");
	}//..		
	
}// end ClockPanel
