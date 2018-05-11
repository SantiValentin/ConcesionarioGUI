package concesionarioGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import concesionario.*;
import exceptions.*;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConcesionarioGUI {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnCar;
	private JMenu mnSearch;
	private JMenu mnHelp;
	private Concesionario warehouse = new Concesionario();
	private Alta add;
	private Baja delete;
	private Mostrar show;
	private EscogerColor chooseColor;
	private Help help;
	private About about;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcesionarioGUI window = new ConcesionarioGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConcesionarioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setResizable(false);
		frame.setTitle("Car Warehouse");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(248, 248, 255));
		menuBar.setBackground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		mnFile.setForeground(new Color(255, 255, 255));
		mnFile.setMnemonic('A');
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New Warehouse");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open Warehouse");
		mnFile.add(mntmOpen);

		mnFile.addSeparator();

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmsSaveAs = new JMenuItem("Save As");
		mntmsSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmsSaveAs);

		mnFile.addSeparator();

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		mnCar = new JMenu("Car");
		mnCar.setForeground(new Color(255, 255, 255));
		mnCar.setMnemonic('C');
		menuBar.add(mnCar);

		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCar();
			}
		});
		mntmAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnCar.add(mntmAdd);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnCar.add(mntmDelete);

		JMenuItem mntmShow = new JMenuItem("Show List");
		mntmShow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					show();
				} catch (EmptyListException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		mnCar.add(mntmShow);

		mnSearch = new JMenu("Search");
		mnSearch.setForeground(new Color(255, 255, 255));
		mnSearch.setMnemonic('B');
		menuBar.add(mnSearch);

		JMenuItem mntmPlate = new JMenuItem("Search By Plate");
		mntmPlate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showByPlate();
			}
		});
		mnSearch.add(mntmPlate);

		JMenuItem mntmColor = new JMenuItem("Search By Color");
		mntmColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showByColor();
			}
		});
		mnSearch.add(mntmColor);

		mnHelp = new JMenu("Help");
		mnHelp.setForeground(new Color(255, 255, 255));
		mnHelp.setMnemonic('A');
		menuBar.add(mnHelp);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help();
			}

		});
		mnHelp.add(mntmHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		mnHelp.add(mntmAbout);

		frame.getContentPane().setLayout(null);
	}

	private void createCar() {
		add = new Alta(warehouse);
		add.setVisible(true);
	}

	private void delete() {
		delete = new Baja(warehouse);
		delete.setVisible(true);
	}

	private void show() throws EmptyListException {
		if (warehouse.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "The Warehouse is Empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		show = new Mostrar(warehouse);
		show.setVisible(true);
	}

	private void showByColor() {
		if (warehouse.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "The Warehouse is Empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		chooseColor = new EscogerColor(warehouse);
		chooseColor.setVisible(true);
	}

	private void showByPlate() {
		if (warehouse.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "The Warehouse is Empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		MostrarPorMatricula searchPlate = new MostrarPorMatricula(warehouse);
		searchPlate.setVisible(true);
	}

	private void about() {
		about = new About();
		about.setVisible(true);
	}

	private void help() {
		help = new Help();
		help.setVisible(true);
	}

}
