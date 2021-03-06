package edu.nku.CSC440.stagbar.ui.dataEntry;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.dataaccess.data.Alcohol;
import edu.nku.CSC440.stagbar.dataaccess.data.CustomAlcoholType;
import edu.nku.CSC440.stagbar.dataaccess.data.Entry;
import edu.nku.CSC440.stagbar.service.AlcoholService;
import edu.nku.CSC440.stagbar.service.TypeService;
import edu.nku.CSC440.stagbar.ui.common.uiHacks;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InventoryUI {
	final Map<CustomAlcoholType, TypePaneUI> typePaneUIMap;
	private JButton cancelButton;
	private JPanel contentPane;
	private JLabel errorMessage;
	private JButton okButton;
	private JPanel scrollPane;

	public InventoryUI() {
		$$$setupUI$$$();
		contentPane.setName("Inventory");

		typePaneUIMap = new HashMap<>();

		populateInventoryByType();

		okButton.addActionListener(e -> onOK());
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
		contentPane.setLayout(new GridLayoutManager(3, 1, new Insets(10, 10, 10, 10), -1, -1));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setHorizontalScrollBarPolicy(30);
		panel1.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		scrollPane1.setViewportView(scrollPane);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		okButton = new JButton();
		okButton.setText("OK");
		panel2.add(okButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel2.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		panel2.add(cancelButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		errorMessage = new JLabel();
		errorMessage.setForeground(new Color(-65536));
		errorMessage.setText("");
		panel3.add(errorMessage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 16), null, 0, false));
	}

	private void createUIComponents() {
		scrollPane = new JPanel();
		scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.Y_AXIS));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Set<Entry> getEntries() {
		boolean failure = false;
		Set<Entry> results = new HashSet<>();
		for(TypePaneUI typePaneUI : typePaneUIMap.values()) {
			try {
				results.addAll(typePaneUI.getEntries());
			} catch(IllegalStateException e) {
				failure = true;
			}
		}

		if(failure) {
			errorMessage.setText("Inventory entry incomplete.");
			results = null;
		}

		return results;
	}

	private void onCancel() {
		uiHacks.killMeThenGoToLastPage(contentPane);
	}

	private void onOK() {
		Set<Entry> entries = getEntries();
		if(null != entries) {
			AlcoholService.getInstance().saveInventory(entries);
			okButton.setEnabled(false);
			uiHacks.killMeThenGoToLastPage(contentPane);
		}
	}

	private void populateInventoryByType() {
		for(CustomAlcoholType type : TypeService.getInstance().getAllCustomAlcoholTypes()) {
			TypePaneUI typePaneUI = new TypePaneUI(type);

			for(Alcohol alcohol : AlcoholService.getInstance().getAlcoholByType(type, LocalDate.now())) {
				typePaneUI.addEntryRow(alcohol);
			}

			if(!typePaneUIMap.isEmpty()) scrollPane.add(new JSeparator(JSeparator.HORIZONTAL));

			typePaneUIMap.put(type, typePaneUI);
			scrollPane.add(typePaneUI.getContentPane());
		}
	}
}
