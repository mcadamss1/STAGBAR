package edu.nku.CSC440.stagbar.ui.common;

import edu.nku.CSC440.stagbar.ui.ApplicationUI;

import javax.swing.*;
import java.awt.*;

/**
 * Temporary measures to ensure functionality
 */
public class uiHacks {

	public static void addNewPanel(JPanel currentPanel, JPanel newPanel) {
		JPanel masterPanel = getMasterPanel(currentPanel);
		masterPanel.add(newPanel);
		((CardLayout)masterPanel.getLayout()).last(masterPanel);
	}

	public static JFrame getContainingFrame(JPanel panel) {
		Component component = panel.getParent();
		while(component.getParent() != null) {
			component = component.getParent();
		}
		return (JFrame)component;
	}

	public static JPanel getMasterPanel(JPanel panel) {
		if("Master".equals(panel.getName())) return panel;

		Component component = panel.getParent();
		while(null != component && !"Master".equals(component.getName())) {
			component = component.getParent();
		}
		return (JPanel)component;
	}

	private static JPanel getTopPanel(JPanel panel){
		JPanel card = null;
		for (Component comp : panel.getComponents()) {
			if (comp.isVisible()) {
				card = (JPanel) comp;
			}
		}
		return card;
	}

	public static void goToPanel(JPanel currentPanel, JPanel newPanel) {
		uiHacks.addNewPanel(currentPanel, newPanel);
		uiHacks.setTitle(newPanel);
		uiHacks.repack(newPanel);
	}

	public static void killMeThenGoToLastPage(JPanel panel) {
		JFrame containingFrame = getContainingFrame(panel);
		JPanel masterPanel = getMasterPanel(panel);
		masterPanel.remove(panel);
		((CardLayout)masterPanel.getLayout()).last(masterPanel);
		containingFrame.pack();
		setTitle(masterPanel);
	}

	public static void repack(JPanel panel) {
		getContainingFrame(panel).pack();
	}

	public static void setTitle(JPanel panel) {
		String title = getTopPanel(getMasterPanel(panel)).getName();
		if(null == title || "Master".equals(title))
			getContainingFrame(panel).setTitle(String.format("%s", ApplicationUI.APPLICATION_TITLE));
		else
			getContainingFrame(panel).setTitle(String.format("%s - %s", ApplicationUI.APPLICATION_TITLE, title));
	}

}
