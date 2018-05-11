package concesionarioGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionario.*;
import java.awt.Color;

public class Padre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblPlate;
	protected JLabel lblColor;
	protected JLabel lblBrand;
	protected JLabel lblModel;
	protected JRadioButton radioButtonSilver;
	protected JRadioButton radioButtonRed;
	protected JRadioButton radioButtonBlue;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> comboBoxBrand;
	protected JComboBox<Modelo> comboBoxModel;
	protected JButton addThings;
	protected JButton delete;
	protected JButton buttonPrevious;
	protected JButton buttonNext;
	protected JButton search;
	protected JButton exit;

	public Padre() {
		super();
		setBackground(new Color(0, 191, 255));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		lblPlate = new JLabel("Plate");
		lblPlate.setBounds(26, 11, 76, 30);
		
		textField = new JTextField();
		textField.setBounds(106, 16, 177, 20);
		textField.setColumns(10);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(26, 58, 49, 14);
		
		radioButtonSilver = new JRadioButton("Silver");
		radioButtonSilver.setBounds(106, 54, 65, 23);
		buttonGroup.add(radioButtonSilver);
		
		radioButtonRed = new JRadioButton("Red");
		radioButtonRed.setBounds(173, 54, 65, 23);
		buttonGroup.add(radioButtonRed);
		
		radioButtonBlue = new JRadioButton("Blue");
		radioButtonBlue.setBounds(238, 54, 65, 23);
		buttonGroup.add(radioButtonBlue);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setBounds(26, 99, 49, 14);
		
		comboBoxBrand = new JComboBox<Marca>();
		comboBoxBrand.setBounds(106, 95, 65, 22);
		comboBoxModel = new JComboBox<Modelo>();
		comboBoxModel.setBounds(106, 138, 92, 22);
		
		lblModel = new JLabel("Model");
		lblModel.setBounds(26, 142, 49, 14);
		
		addThings = new JButton("Add");
		addThings.setBounds(205, 164, 86, 23);
		
		delete = new JButton("Delete");
		delete.setBounds(205, 164, 86, 23);
		
		buttonPrevious = new JButton("<");
		buttonPrevious.setBounds(205, 164, 43, 23);
		
		buttonNext = new JButton(">");
		buttonNext.setBounds(248, 164, 43, 23);
		
		search = new JButton("Search");
		search.setBounds(205, 164, 86, 23);
		
		exit = new JButton("Exit");
		exit.setBounds(300, 164, 65, 23);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(lblBrand);
		getContentPane().add(lblModel);
		getContentPane().add(lblColor);
		getContentPane().add(lblPlate);
		getContentPane().add(radioButtonSilver);
		getContentPane().add(radioButtonRed);
		getContentPane().add(radioButtonBlue);
		getContentPane().add(addThings);
		getContentPane().add(delete);
		getContentPane().add(buttonPrevious);
		getContentPane().add(buttonNext);
		getContentPane().add(search);
		getContentPane().add(exit);
		getContentPane().add(comboBoxBrand);
		getContentPane().add(comboBoxModel);
		getContentPane().add(textField);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}