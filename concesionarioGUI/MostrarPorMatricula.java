package concesionarioGUI;

import javax.swing.JOptionPane;

import concesionario.*;
import exceptions.NotValidPlateException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPorMatricula extends Padre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarPorMatricula(Concesionario warehouse) {
		super();
		setTitle("Search By License Plate");

		addThings.setVisible(false);
		delete.setVisible(false);
		buttonPrevious.setVisible(false);
		buttonNext.setVisible(false);

		radioButtonSilver.setEnabled(false);
		radioButtonRed.setEnabled(false);
		radioButtonBlue.setEnabled(false);

		comboBoxBrand.setEnabled(false);
		comboBoxModel.setEnabled(false);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche car = null;
				try {
					car = warehouse.searchByPlate(textField.getText());
				} catch (NotValidPlateException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
				}
				if (car != null) {
					showCar(car);
				} else {
					JOptionPane.showMessageDialog(contentPanel, "No car was registered with that plate", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void showCar(Coche car) {
		switch (car.getColor()) {
		case GREY:
			radioButtonSilver.setSelected(true);
			break;
		case RED:
			radioButtonBlue.setSelected(true);
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