package es.deusto.ingenieria.intelligensystems.heartfailure.main;

import javax.swing.SwingUtilities;

import es.deusto.ingenieria.intelligensystems.heartfailure.controller.HeartFailureController;
import es.deusto.ingenieria.intelligensystems.heartfailure.gui.MainWindow;

public class MainProgram {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainWindow(new HeartFailureController()));
	}
}