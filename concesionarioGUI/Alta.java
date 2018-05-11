package concesionarioGUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import concesionario.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta extends Padre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Alta(Concesionario warehouse) {
		super();
		setTitle("Add Car");

		delete.setVisible(false);
		search.setVisible(false);
		buttonPrevious.setVisible(false);
		buttonNext.setVisible(false);

		comboBoxBrand.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModel.setModel(new DefaultComboBoxModel(getModel(comboBoxBrand)));
			}
		});
		comboBoxBrand.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModel.setModel(new DefaultComboBoxModel(getModel(comboBoxBrand)));

		addThings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (warehouse.createCar(textField.getText(), getColor(),
							(Modelo) comboBoxModel.getSelectedItem()))
						JOptionPane.showMessageDialog(contentPanel,
								"Car added");
					else
						JOptionPane.showMessageDialog(contentPanel,
								"Car cannot be added. One or more fields are empty/incorrect", "Error",
								JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private Object[] getModel(JComboBox<Marca> comboBoxBrand) {
		Marca brand = (Marca) comboBoxBrand.getSelectedItem();
		ArrayList<Modelo> models = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getBrand() == brand)
				models.add(m);
		}
		return models.toArray();
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