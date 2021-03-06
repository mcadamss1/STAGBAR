package edu.nku.CSC440.stagbar.ui.common;

import edu.nku.CSC440.stagbar.dataaccess.data.MixedDrink;

import javax.swing.*;
import java.awt.*;

public class MixedDrinkCheckBox extends JCheckBox {

	private final MixedDrink mixedDrink;

	public MixedDrinkCheckBox(MixedDrink mixedDrink) {
		super(mixedDrink.getName());
		this.mixedDrink = mixedDrink;
		setPreferredSize(new Dimension(150, -1));
	}

	public MixedDrink getMixedDrink() {
		return mixedDrink;
	}
}
