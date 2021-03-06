package edu.nku.CSC440.stagbar.ui.alcohol;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.dataaccess.data.AlcoholType;
import edu.nku.CSC440.stagbar.dataaccess.data.CustomAlcoholType;
import edu.nku.CSC440.stagbar.service.AlcoholService;
import edu.nku.CSC440.stagbar.service.TypeService;
import edu.nku.CSC440.stagbar.ui.common.ImprovedFormattedTextField;
import edu.nku.CSC440.stagbar.ui.common.uiHacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Set;

public class CreateAlcoholUI {
	private static final String ERROR_CANNOT_SAVE = "Unable to save new alcohol. Try again later.";
	private static final String ERROR_INVALID_QUANTITIES = "Invalid entry in Bottles/Amount fields.";
	private static final String ERROR_NAME_NOT_UNIQUE = "An alcohol with that name already exists.";
	private static final String ERROR_REQUIRED_FIELDS = "All fields must be filled.";
	private static final String MESSAGE_NEW_ALCOHOL = "%s has been saved.";
	private static final String TITLE_CANNOT_SAVE = "Alcohol Save Failed";
	private static final String TITLE_NEW_ALCOHOL = "Save Successful";
	private JFormattedTextField amountFormattedTextField;
	private JFormattedTextField bottlesFormattedTextField;
	private JButton cancelButton;
	private JPanel contentPane;
	private JLabel errorMessage;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton okButton;
	private JComboBox<CustomAlcoholType> typeComboBox;
	private JLabel typeLabel;

	public CreateAlcoholUI() {
		$$$setupUI$$$();
		contentPane.setName("New Alcohol");

		okButton.addActionListener(e -> onOK());
		typeComboBox.addItemListener(e -> {
			if(e.getStateChange() == ItemEvent.SELECTED) {
//				toggleFields(((CustomAlcoholType)e.getItem()).getKind()); //FIXME: Disable initial amount entry. Non-functional. May be removed.
			}
		});

		cancelButton.addActionListener(e -> onCancel());
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
		contentPane.setLayout(new GridLayoutManager(5, 1, new Insets(10, 10, 10, 10), 0, 0));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		nameLabel = new JLabel();
		nameLabel.setText("Name:");
		panel1.add(nameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		nameTextField = new JTextField();
		panel1.add(nameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		typeLabel = new JLabel();
		typeLabel.setText("Type:");
		panel1.add(typeLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		panel1.add(typeComboBox, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setText("Bottles:");
		panel2.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setText("Amount (oz):");
		panel2.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		bottlesFormattedTextField.setText("0");
		panel2.add(bottlesFormattedTextField, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		amountFormattedTextField.setText("0.0");
		panel2.add(amountFormattedTextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		okButton = new JButton();
		okButton.setText("OK");
		panel3.add(okButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel3.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		panel3.add(cancelButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		errorMessage = new JLabel();
		errorMessage.setForeground(new Color(-65536));
		errorMessage.setText("");
		panel4.add(errorMessage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 16), null, 0, false));
		final JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel5, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label3 = new JLabel();
		label3.setText("Initial Amount on Hand:");
		panel5.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		nameLabel.setLabelFor(nameTextField);
		typeLabel.setLabelFor(typeComboBox);
		label1.setLabelFor(bottlesFormattedTextField);
		label2.setLabelFor(amountFormattedTextField);
	}

	private void createUIComponents() {
		Set<CustomAlcoholType> allCustomAlcoholTypes = TypeService.getInstance().getAllCustomAlcoholTypes();
		typeComboBox = new JComboBox<>(allCustomAlcoholTypes.toArray(new CustomAlcoholType[allCustomAlcoholTypes.size()]));
		typeComboBox.setSelectedIndex(-1);

		NumberFormat integerNumberInstance = NumberFormat.getIntegerInstance();
		bottlesFormattedTextField = new ImprovedFormattedTextField(integerNumberInstance, 0);
		bottlesFormattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		bottlesFormattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		bottlesFormattedTextField.setEnabled(false);

		NumberFormat decimalNumberInstance = new DecimalFormat();
		amountFormattedTextField = new ImprovedFormattedTextField(decimalNumberInstance, 0);
		amountFormattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountFormattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		amountFormattedTextField.setEnabled(false);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * Turns blank fields RED and reverts filled fields to BLACK.
	 */
	private void highlightEmptyFields() {
		nameLabel.setForeground(nameTextField.getText().isEmpty() ?
														Color.RED : Color.BLACK);

		typeLabel.setForeground(null == typeComboBox.getSelectedItem() ?
														Color.RED : Color.BLACK);
	}

	private void onCancel() {
		uiHacks.killMeThenGoToLastPage(contentPane);
	}

	private void onOK() {
		int bottles = 0;
		double amount = 0.0;
		boolean validQuantities = true;

		highlightEmptyFields();

		try {
			bottles = Integer.parseInt(bottlesFormattedTextField.getText());
			amount = Double.parseDouble(amountFormattedTextField.getText());
		} catch(NumberFormatException e) {
			validQuantities = false;
		}

		// Check name & type fields are filled.
		if(nameTextField.getText().isEmpty() || null == typeComboBox.getSelectedItem()) {
			errorMessage.setText(ERROR_REQUIRED_FIELDS);
		}
		// Check bottles & amount have valid values.
		else if(!validQuantities) { // UI should already have a red background indicator for invalid fields.
			errorMessage.setText(ERROR_INVALID_QUANTITIES);
		}
		// Check name is unique in database.
		else if(AlcoholService.getInstance().isAlcoholNameUnique(nameTextField.getText(), (CustomAlcoholType)typeComboBox.getSelectedItem())) {
			nameLabel.setForeground(Color.RED);
			errorMessage.setText(ERROR_NAME_NOT_UNIQUE);
			nameTextField.selectAll();
			nameTextField.requestFocusInWindow();
		}
		// Save alcohol to database.
		else if(AlcoholService.getInstance().saveNewAlcohol(nameTextField.getText(), (CustomAlcoholType)typeComboBox.getSelectedItem())) {
			// Display confirmation to user
			JOptionPane.showMessageDialog(contentPane, String.format(MESSAGE_NEW_ALCOHOL, nameTextField.getText()), TITLE_NEW_ALCOHOL, JOptionPane.INFORMATION_MESSAGE);

			okButton.setEnabled(false);
			uiHacks.killMeThenGoToLastPage(contentPane);
		}
		else {
			JOptionPane.showMessageDialog(contentPane, ERROR_CANNOT_SAVE, TITLE_CANNOT_SAVE, JOptionPane.ERROR_MESSAGE);
		}
	}

	/** Disable bottles/amount fields based on AlcoholType selected. */
	private void toggleFields(AlcoholType type) {
		switch(type) {
			case BOTTLED:
				bottlesFormattedTextField.setEnabled(true);
				bottlesFormattedTextField.requestFocusInWindow();

				amountFormattedTextField.setEnabled(false);
				amountFormattedTextField.setText("0.0");
				break;
			case DRAFT:
				bottlesFormattedTextField.setEnabled(false);
				bottlesFormattedTextField.setText("0");

				amountFormattedTextField.setEnabled(true);
				amountFormattedTextField.requestFocusInWindow();
				break;
			case SHELF:
				bottlesFormattedTextField.setEnabled(true);
				bottlesFormattedTextField.requestFocusInWindow();

				amountFormattedTextField.setEnabled(true);
				break;
			default:
				bottlesFormattedTextField.setEnabled(false);
				amountFormattedTextField.setEnabled(false);
				break;
		}
	}

}
