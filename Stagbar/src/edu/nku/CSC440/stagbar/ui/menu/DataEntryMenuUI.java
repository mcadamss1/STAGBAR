package edu.nku.CSC440.stagbar.ui.menu;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.ui.common.uiHacks;
import edu.nku.CSC440.stagbar.ui.dataEntry.DeliveryUI;
import edu.nku.CSC440.stagbar.ui.dataEntry.InventoryUI;
import edu.nku.CSC440.stagbar.ui.dataEntry.SalesUI;

import javax.swing.*;
import java.awt.*;

public class DataEntryMenuUI {
	private JPanel contentPane;
	private JButton deliveriesButton;
	private JButton goBackButton;
	private JButton inventoryButton;
	private JButton salesButton;

	public DataEntryMenuUI() {
		contentPane.setName("Data Entry Menu");

		inventoryButton.addActionListener(e -> onInventory());
		salesButton.addActionListener(e -> onSales());
		deliveriesButton.addActionListener(e -> onDeliveries());
		goBackButton.addActionListener(e -> onGoBack());
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
		contentPane = new JPanel();
		contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(10, 10, 10, 10), -1, -1));
		contentPane.setPreferredSize(new Dimension(250, 155));
		inventoryButton = new JButton();
		inventoryButton.setText("Inventory");
		contentPane.add(inventoryButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		salesButton = new JButton();
		salesButton.setText("Sales");
		contentPane.add(salesButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		deliveriesButton = new JButton();
		deliveriesButton.setText("Deliveries");
		contentPane.add(deliveriesButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		goBackButton = new JButton();
		goBackButton.setText("Go Back");
		contentPane.add(goBackButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	private void onDeliveries() {
		DeliveryUI deliveryUI = new DeliveryUI();
		uiHacks.goToPanel(contentPane, deliveryUI.getContentPane());
	}

	private void onGoBack() {
		uiHacks.killMeThenGoToLastPage(contentPane);
	}

	private void onInventory() {
		InventoryUI inventoryUI = new InventoryUI();
		uiHacks.goToPanel(contentPane, inventoryUI.getContentPane());
	}

	private void onSales() {
		SalesUI salesUI = new SalesUI();
		uiHacks.goToPanel(contentPane, salesUI.getContentPane());
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

}