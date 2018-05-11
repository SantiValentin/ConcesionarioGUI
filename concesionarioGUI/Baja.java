package concesionarioGUI;

import javax.swing.JOptionPane;

import concesionario.*;
import exceptions.EmptyListException;
import exceptions.NotValidPlateException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baja extends Padre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Baja(Concesionario warehouse) {
		super();
		setTitle("Delete Car");

		addThings.setVisible(false);
		search.setVisible(false);
		buttonPrevious.setVisible(false);
		buttonNext.setVisible(false);

		radioButtonSilver.setEnabled(false);
		radioButtonRed.setEnabled(false);
		radioButtonBlue.setEnabled(false);

		comboBoxBrand.setEnabled(false);
		comboBoxModel.setEnabled(false);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche car = null;
				try {
					car = warehouse.searchByPlate(textField.getText());
				} catch (NotValidPlateException e1) {
					e1.printStackTrace();
				}
				if (car != null) {
					showCar(car);
					int n = JOptionPane.showOptionDialog(contentPanel, "Delete car?", "Confirmation",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					switch (n) {
					case JOptionPane.YES_OPTION:
						try {
							warehouse.deleteCar(textField.getText());
						} catch (EmptyListException | NotValidPlateException e1) {
							e1.printStackTrace();
						}
						clear();
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel, "Car cannot be deleted", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void clear() {
		textField.setText("");
		buttonGroup.clearSelection();
		comboBoxBrand.setSelectedItem(null);
		comboBoxModel.setSelectedItem(null);
	}

	private void showCar(Coche car) {
		switch (car.getColor()) {
		case GREY:
			radioButtonSilver.setSelected(true);
			break;
		case RED:
			radioButtonRed.setSelected(true);
			break;
		case BLUE:
			radioButtonBlue.setSelected(true);
		}
		comboBoxBrand.addItem(car.getModel().getBrand());
		comboBoxBrand.setSelectedItem(car.getModel().getBrand());
		comboBoxModel.addItem(car.getModel());
		comboBoxModel.setSelectedItem(car.getModel());
	}

}