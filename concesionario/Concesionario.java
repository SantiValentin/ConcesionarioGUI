package concesionario;

import java.util.ArrayList;

import exceptions.*;

/**
 * 
 * @author Santiago Valentin Serrano
 * @version 1.0
 */
public class Concesionario {
	private ArrayList<Coche> list = new ArrayList<Coche>();

	/**
	 * Creates a car
	 * 
	 * @param position
	 * @param car
	 * @throws Exception
	 * @throws OutOfRangeException
	 */
	public boolean createCar(String plate, Color color, Modelo model) throws Exception {
		Coche coche = Coche.instanceCoche(model, color, plate);
		if (coche == null || list.contains(coche))
			return false;
		return list.add(coche);
	}

	/**
	 * Shows a car from the list
	 * 
	 * @param index
	 * @throws EmptyListException
	 */
	public Coche showCar(int index) throws EmptyListException {
		if (list.isEmpty())
			return null;
		if (index < 0 | index > list.size() - 1)
			return null;
		return list.get(index);
	}

	/**
	 * Prints the entire list unless is empty
	 * 
	 * @throws EmptyListException
	 */
	public String showList() throws EmptyListException {
		checkIsEmpty();
		StringBuilder list1 = new StringBuilder();
		for (Coche car : list) {
			list1.append("\n" + car);
		}
		return list1.toString();
	}

	/**
	 * <li>Deletes a car from the list
	 * <li>The is deleted by plate number
	 * 
	 * @param position
	 * @throws EmptyListException
	 * @throws NotValidPlateException
	 * @throws Exception
	 */
	public boolean deleteCar(String plate) throws EmptyListException, NotValidPlateException {
		checkIsEmpty();
		return list.remove(Coche.instanceCoche(plate));
	}

	/**
	 * <li>Searches a car by it's license plate
	 * 
	 * @param plate
	 * @return
	 * @throws NotValidPlateException
	 */
	public Coche searchByPlate(String plate) throws NotValidPlateException {
		Coche car = new Coche(plate);
		int index = list.indexOf(car);
		if (index != -1) {
			return list.get(index);
		}
		return null;
	}

	/**
	 * <li>Searches car by it's color
	 * 
	 * @return
	 * @throws EmptyListException
	 */
	public ArrayList<Coche> searchByColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : list) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

	/**
	 * @return size
	 */
	public int size() {
		return list.size();
	}

	/**
	 * @return list is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * @throws EmptyListException
	 */
	private void checkIsEmpty() throws EmptyListException {
		if (list.isEmpty()) {
			throw new EmptyListException("The list is empty");
		}
	}
}
