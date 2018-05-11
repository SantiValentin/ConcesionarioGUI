package concesionarioGUI;

import concesionario.*;

import exceptions.EmptyListException;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class Mostrar extends Padre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Concesionario warehouse;
	private int index = 1;

	/**
	 * Create the dialog.
	 * 
	 * @throws EmptyListException
	 */
	public Mostrar(Concesionario warehouse) throws EmptyListException {
		super();
		setTitle("Show Warehouse List");

		this.warehouse = warehouse;

		addThings.setVisible(false);
		delete.setVisible(false);
		search.setVisible(false);

		textField.setEnabled(false);

		radioButtonSilver.setEnabled(false);
		radioButtonRed.setEnabled(false);
		radioButtonBlue.setEnabled(false);

		comboBoxBrand.setEnabled(false);
		comboBoxModel.setEnabled(false);

		buttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showPrevious();
				} catch (EmptyListException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
				}
			}
		});

		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showNext();
				} catch (EmptyListException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
				}
			}
		});
		update();
	}

	void update() throws EmptyListException {
		if (warehouse.size() == 0) {
			return;
		}
		index = 0;
		showCar(warehouse.showCar(index));
		checkButtons();
	}

	private void showNext() throws EmptyListException {
		showCar(warehouse.showCar(++index));
		checkButtons();
	}

	private void showPrevious() throws EmptyListException {
		showCar(warehouse.showCar(--index));
		checkButtons();
	}

	private void showCar(Coche car) {
		textField.setText(car.getPlate());
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

	private void checkButtons() throws EmptyListException {
		if (warehouse.showCar(index + 1) == null)
			buttonNext.setEnabled(false);
		else
			buttonNext.setEnabled(true);

		if (warehouse.showCar(index - 1) == null)
			buttonPrevious.setEnabled(false);
		else
			buttonPrevious.setEnabled(true);
	}
}