package edu.nku.CSC440.stagbar.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.dataaccess.Alcohol;
import edu.nku.CSC440.stagbar.dataaccess.MixedDrinkIngredient;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class IngredientRowUI {

	private Alcohol alcohol;
	private JLabel alcoholLabel;
	private JFormattedTextField amountFormattedTextField;
	private JPanel contentPane;
	private JButton removeButton;

	public IngredientRowUI(Alcohol ingredient) {
		if(null == alcohol) throw new IllegalArgumentException("Alcohol cannot be null.");

		this.alcohol = ingredient;
		$$$setupUI$$$();
		alcoholLabel.setText(ingredient.getName());

		amountFormattedTextField.setText(String.valueOf(0));
		removeButton.addActionListener(e -> onRemove());
	}

	public IngredientRowUI(Alcohol ingredient, double amount) {
		this(ingredient);
		amountFormattedTextField.setText(String.valueOf(amount));
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
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
		alcoholLabel = new JLabel();
		alcoholLabel.setText("Label");
		contentPane.add(alcoholLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		amountFormattedTextField.setText("0");
		contentPane.add(amountFormattedTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		removeButton = new JButton();
		removeButton.setText("Remove");
		contentPane.add(removeButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		alcoholLabel.setLabelFor(amountFormattedTextField);
	}

	private void createUIComponents() {
		NumberFormat decimalNumberInstance = new DecimalFormat();
		amountFormattedTextField = new ImprovedFormattedTextField(decimalNumberInstance, null);
		amountFormattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountFormattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public MixedDrinkIngredient getIngredient() {
		double amount;
		alcoholLabel.setForeground(Color.BLACK);

		try {
			amount = Double.parseDouble(amountFormattedTextField.getText());
		} catch(NumberFormatException e) {
			alcoholLabel.setForeground(Color.RED);
			throw new IllegalStateException(e);
		}

		return new MixedDrinkIngredient(alcohol, amount);
	}

	private void onRemove() {
		//TODO: Remove this ingredient
	}

}
