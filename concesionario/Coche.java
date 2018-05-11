package concesionario;

import java.util.regex.Pattern;

import exceptions.*;

/**
 * Contains car's info such as brand, model, color and license plate
 * 
 * @author Santiago Valentin Serrano
 * @version 1.0
 */
public class Coche {

	private Modelo model;
	private Color color;
	private String plate;
	static final private Pattern licensePlate = Pattern.compile("^([0-9]{4})+([\\s-]?)([B-Z&&[^EIOUQ]]{3})");

	public Coche(Modelo model, Color color, String plate) throws Exception {
		setColor(color);
		setModel(model);
		setPlate(plate);
	}

	public Coche(String plate) throws NotValidPlateException {
		setPlate(plate);
	}

	public Coche(Color color) {
		setColor(color);
	}

	static Coche instanceCoche(Modelo model, Color color, String plate) throws Exception {
		if (validPlate(plate) && color != null && model != null)
			return new Coche(model, color, plate);
		return null;
	}

	static Coche instanceCoche(String plate) throws NotValidPlateException {
		if (validPlate(plate))
			return new Coche(plate);
		return null;
	}

	public String getPlate() {
		return plate;
	}

	public Modelo getModel() {
		return model;
	}

	public void setModel(Modelo model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPlate(String plate) throws NotValidPlateException {
		if (!validPlate(plate))
			throw new NotValidPlateException("That plate is not correct");
		this.plate = plate;
	}

	/**
	 * <li>Returns correct plate
	 * 
	 * @param plate
	 * @return valid license plate
	 */
	public static boolean validPlate(String plate) {
		return licensePlate.matcher(plate).matches();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Coche other = (Coche) o;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car: " + model + ", Color: " + color + ", License Plate: " + plate;
	}
}
