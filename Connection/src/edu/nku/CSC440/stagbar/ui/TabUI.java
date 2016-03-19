package edu.nku.CSC440.stagbar.ui;

import edu.nku.CSC440.stagbar.dataaccess.Alcohol;
import edu.nku.CSC440.stagbar.dataaccess.MixedDrink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class TabUI {
	private ItemListener checkBoxListener;
	private JPanel contentPane;

	public TabUI(ItemListener checkBoxListener) {
		this.checkBoxListener = checkBoxListener;
	}

	/** @noinspection ALL */
	public JComponent $$$getRootComponent$$$() { return contentPane; }

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		createUIComponents();
	}

	public void addCheckbox(Alcohol alcohol) {
		AlcoholCheckBox alcoholCheckBox = new AlcoholCheckBox(alcohol);
		alcoholCheckBox.addItemListener(checkBoxListener);
		contentPane.add(alcoholCheckBox);
	}

	public void addCheckbox(MixedDrink mixedDrink) {
		MixedDrinkCheckBox mixedDrinkCheckBox = new MixedDrinkCheckBox(mixedDrink);
		mixedDrinkCheckBox.addItemListener(checkBoxListener);
		contentPane.add(mixedDrinkCheckBox);
	}

	private void createUIComponents() {
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 3));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

}
