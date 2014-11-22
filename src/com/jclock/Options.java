package com.jclock;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Options {

	
	static boolean alwaysOnTop = false,
				   isMoveable = true;	

	static int formatNum = 2,fontSize = 60;
	final static String timeFormat[] = {"h:mm","hh:mm","h:mm a","hh:mm a"};
	
	static SimpleDateFormat clockStyle = new SimpleDateFormat(timeFormat[formatNum]);

    static Color color = Color.GREEN;
    static Vector<Color> colors = new Vector<Color>();
}// end Options
