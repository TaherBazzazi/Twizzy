package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Interface.*;
import OpenCV.MainTraitementImage;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {

		MainTraitementImage prog = new MainTraitementImage();

		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		// start my window
		LaunchWindow myLaunchWindow = new LaunchWindow();
		myLaunchWindow.setVisible(true);
	}

}
