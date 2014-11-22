package com.jclock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Jclock_Menu extends JPopupMenu {

	static Options options = new Options();
	
	JMenuItem setFontSize = new JMenuItem("Set Font Size");
	
	JCheckBoxMenuItem alwaysoOnTop = new JCheckBoxMenuItem("Always on Top",options.alwaysOnTop),
			          isMoveable = new JCheckBoxMenuItem("Moveable",options.isMoveable);
	
	JMenu formatMenu = new JMenu("Format");
    JMenu colorMenu = new JMenu("Color");
	
	public Jclock_Menu() {		
		
		alwaysoOnTop.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JClock.main.setAlwaysOnTop(Options.alwaysOnTop = !Options.alwaysOnTop);
			}
		});
		
		isMoveable.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Options.isMoveable = !Options.isMoveable;
			}
		});
			
		ButtonGroup fGroup = new ButtonGroup();
		for(int i=0;i<Options.timeFormat.length;i++){
			JRadioButtonMenuItem cb = new JRadioButtonMenuItem(Options.timeFormat[i],i==Options.formatNum?true:false);
			final int z = i;
			cb.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					Options.clockStyle = new SimpleDateFormat(Options.timeFormat[z]);
				}
			});
			fGroup.add(cb);	
			formatMenu.add(cb);
		}



        Options.colors.add(Color.black);
        Options.colors.add(Color.red);
        Options.colors.add(Color.green);
        Options.colors.add(Color.blue);
        Options.colors.add(Color.pink);
        Options.colors.add(Color.gray);
        Options.colors.add(Color.CYAN);
        Options.colors.add(Color.MAGENTA);
        Options.colors.add(Color.ORANGE);
        Options.colors.add(Color.white);
        for (Color c: Options.colors){
            JMenuItem itm = new JMenuItem();
            final Color col = c;
            itm.setBackground(c);
            itm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Options.color = col;
                }
            });
            colorMenu.add(itm);
        }




		
		setFontSize.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog("Enter JClock Font Size");
				if(!s.isEmpty()){
					try{
						// 17.5:3 ratio
						int fs = Integer.parseInt(s),
							w = fs*(int)5.8333333;
						JClock.main.setSize(w,fs);
						JClock_Panel.timeLabel.setSize(w,fs);
						JClock_Panel.timeLabel.setFont (JClock_Panel.timeLabel.getFont ().deriveFont ((float)fs));//change font size
						
					}catch(Exception ex){}					
				}
			}
		});

		add(isMoveable);
		add(alwaysoOnTop);
		add(new Separator());
		add(setFontSize);
        add(colorMenu);
		add(formatMenu);
		add(new Separator());
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		add(exit);
	}//..
	
	
}//..
