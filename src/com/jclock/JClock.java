package com.jclock;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class JClock extends JDialog{
	
	static JDialog main;
	static Jclock_Menu menu;
	
	JClock(){
		main = this;
		menu = new Jclock_Menu();
		
		setUndecorated(true);
		setTitle("JClock");
		setLayout(null);
		setSize(350,60);
		setLocationRelativeTo(null);	
		setBackground(new Color(0,0,0,0));
		setContentPane(new JClock_Panel());
		setVisible(true);	
		
	}//...	
	
	public static void main(String[] args) {

		Color c = Color.white;
		UIDefaults ui = UIManager.getLookAndFeelDefaults();
		ui.put("MenuItem.opaque", true);
		ui.put("Menu.opaque", true);
		ui.put("PopupMenu.background", c);
		ui.put("Menu.background", c);
		ui.put("MenuItem.background", c);
		ui.put("CheckBoxMenuItem.background", c);
		new JClock();
	}//..

}//..

