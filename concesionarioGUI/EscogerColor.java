package concesionarioGUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import concesionario.*;
import exceptions.EmptyListException;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;

public class EscogerColor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblColor;
	private JRadioButton radioButtonSilver;
	private JRadioButton radioButtonRed;
	private JRadioButton radioButtonBlue;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton accept;
	private JButton exit;
	private MostrarPorColor showByColor;

	/**
	 * Create the dialog.
	 */
	public EscogerColor(Concesionario warehouse) {
		setTitle("Choose Color");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 298, 109);

		lblColor = new JLabel("Color");
		lblColor.setBounds(20, 11, 49, 14);

		radioButtonSilver = new JRadioButton("Silver");
		radioButtonSilver.setBounds(100, 7, 65, 23);
		buttonGroup.add(radioButtonSilver);

		radioButtonRed = new JRadioButton("Red");
		radioButtonRed.setBounds(167, 7, 65, 23);
		buttonGroup.add(radioButtonRed);

		radioButtonBlue = new JRadioButton("Blue");
		radioButtonBlue.setBounds(232, 7, 65, 23);
		buttonGroup.add(radioButtonBlue);

		accept = new JButton("Accept");
		accept.setBounds(114, 48, 86, 23);
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = getColor();
				if (color != null) {
					ArrayList<Coche> cars = warehouse.searchByColor(color);
					if (cars.isEmpty()) {
						JOptionPane.showMessageDialog(contentPanel, "No cars stored with that color", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						showByColor = new MostrarPorColor(cars);
					} catch (EmptyListException e1) {
						JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					showByColor.setVisible(true);
				} else
					JOptionPane.showMessageDialog(contentPanel, "Choose a color", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		exit = new JButton("Exit");
		exit.setBounds(210, 48, 65, 23);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(lblColor);
		getContentPane().add(accept);
		getContentPane().add(exit);
		getContentPane().add(radioButtonSilver);
		getContentPane().add(radioButtonRed);
		getContentPane().add(radioButtonBlue);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	private Color getColor() {
		if (radioButtonSilver.isSelected())
			return Color.GREY;
		else if (radioButtonRed.isSelected())
			return Color.RED;
		else if (radioButtonBlue.isSelected())
			return Color.BLUE;
		else
			return null;
	}

}