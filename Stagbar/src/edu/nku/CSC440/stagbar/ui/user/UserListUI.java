package edu.nku.CSC440.stagbar.ui.user;

import javax.swing.*;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.dataaccess.data.PermissionLevel;
import edu.nku.CSC440.stagbar.dataaccess.data.User;
import edu.nku.CSC440.stagbar.service.UserService;
import edu.nku.CSC440.stagbar.Application;

import java.awt.*;

public class UserListUI {
    private JPanel contentPane;
    private JRadioButton adminRadio;
    private JRadioButton guestRadio;
    private JLabel userLabel;
    private UserService userService;
    private User user;
    private Application application;

    public UserListUI(User user) {
        if (null == user) throw new IllegalArgumentException("User cannot be null.");

        this.user = user;
        //$$$setupUI$$$();
        $$$setupUI$$$();
        userLabel.setText(user.getUsername());
    }


    private void createUIComponents() {
        userLabel = new JLabel();
        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userLabel.setText(user.getUsername());
        userLabel.setEnabled(true);

        adminRadio = new JRadioButton();
        guestRadio = new JRadioButton();

        if (Application.getInstance().getUser().getPermissionLevel().equals(PermissionLevel.ADMIN)) {
            adminRadio.setSelected(true);
            guestRadio.setSelected(false);
        } else if (Application.getInstance().getUser().getPermissionLevel().equals(PermissionLevel.GUEST)) {
            adminRadio.setSelected(false);
            guestRadio.setSelected(true);
        }
    }


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
        userLabel.setText("Label");
        contentPane.add(userLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adminRadio.setText("RadioButton");
        contentPane.add(adminRadio, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        guestRadio.setText("RadioButton");
        contentPane.add(guestRadio, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
