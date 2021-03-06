package edu.nku.CSC440.stagbar.ui.demo;


import edu.nku.CSC440.stagbar.ui.common.ImprovedFormattedTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * See http://stackoverflow.com/q/1313390/1076463
 */
@Deprecated
public class FormattedTextFieldDemo {
	private static JPanel createButtonPanel( final JFormattedTextField aTextField ){
		JPanel panel = new JPanel( new BorderLayout(  ) );
		panel.add( aTextField, BorderLayout.WEST );

		Action action = new AbstractAction() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				JOptionPane.showMessageDialog( null, "The current value is [" + aTextField.getValue() + "] of class [" + aTextField.getValue().getClass() + "]" );
			}

			{
				aTextField.addPropertyChangeListener( "editValid", new PropertyChangeListener() {
					@Override
					public void propertyChange( PropertyChangeEvent evt ) {
						setEnabled( ( ( Boolean ) evt.getNewValue() ) );
					}
				} );
				putValue( Action.NAME, "Show current value" );
			}
		};
		panel.add( new JButton( action ), BorderLayout.EAST );
		return panel;
	}

	public static void main( String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame testFrame = new JFrame( "FormattedTextFieldDemo" );

				NumberFormat integerNumberInstance = NumberFormat.getIntegerInstance();
				ImprovedFormattedTextField integerFormattedTextField = new ImprovedFormattedTextField( integerNumberInstance, 100 );
				integerFormattedTextField.setColumns( 20 );

				testFrame.add( createButtonPanel( integerFormattedTextField ), BorderLayout.NORTH );

				final JTextArea textArea = new JTextArea(50, 50);
				PropertyChangeListener updateTextAreaListener = new PropertyChangeListener() {
					@Override
					public void propertyChange( PropertyChangeEvent evt ) {
						textArea.append( "New value: " + evt.getNewValue() + "\n" );
					}
				};
				integerFormattedTextField.addPropertyChangeListener( "value", updateTextAreaListener );

				testFrame.add( new JScrollPane( textArea ), BorderLayout.CENTER );

				testFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
				testFrame.pack();
				testFrame.setVisible( true );
			}
		} );

	}
}