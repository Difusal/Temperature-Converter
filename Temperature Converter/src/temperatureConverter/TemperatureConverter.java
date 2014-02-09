package temperatureConverter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter {
	// main frame
	private JFrame frame;
	
	// text fields
	private JTextField celsiusField;
	private JTextField fahrenheitField;
	private JTextField kelvinField;
	
	// labels
	private JLabel celsiusLabel;
	private JLabel fahrenheitLabel;
	private JLabel kelvinLabel;
	
	// buttons
	private JButton convertCelsius;
	private JButton convertFahr;
	private JButton convertKelvin;
	
	// constructor, prepares and displays the main window
	public TemperatureConverter() {
		// create and configure the main window
		frame = new JFrame("Temperature Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// choosing an appropriate layout manager
		frame.getContentPane().setLayout(new GridLayout(3, 3));
		
		// creating widgets and adding them
		createWidgets();
		addWidgets(frame.getContentPane());
		
		// resizing and displaying window
		frame.pack();
		frame.setVisible(true);
	}
	
	// used by constructor, creates and adds widgets
	private void createWidgets() {
		// creating widgets
		celsiusField = new JTextField();
		celsiusLabel = new JLabel("Celsius");

		fahrenheitField = new JTextField();
		fahrenheitLabel = new JLabel("Fahrenheit");
		
		kelvinField = new JTextField();
		kelvinLabel = new JLabel("Kelvin");

		convertCelsius = new JButton("Convert Celsius");
		convertFahr = new JButton("Convert Fahrenheit");
		convertKelvin = new JButton("Convert Kelvin");
		
		// assigning button event listeners
		convertCelsius.addActionListener(new ConvertCelsiusListener());
		convertFahr.addActionListener(new ConvertFahrListener());
		convertKelvin.addActionListener(new ConvertKelvinListener());
	}
	private void addWidgets(Container cont) {
		// adding widgets to window by correct order
		cont.add(celsiusLabel);
		cont.add(fahrenheitLabel);
		cont.add(kelvinLabel);
		
		cont.add(celsiusField);
		cont.add(fahrenheitField);
		cont.add(kelvinField);
		
		cont.add(convertCelsius);
		cont.add(convertFahr);
		cont.add(convertKelvin);
	}
	
	// button listeners
	private class ConvertCelsiusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double tempCelsius;
			
			try {
				tempCelsius = Double.parseDouble(celsiusField.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Invalid format");
				return;
			
			}

			double tempFahr = tempCelsius*1.8 + 32;
			double tempKelvin = tempCelsius + 273.15;
			
			fahrenheitField.setText(Double.toString(tempFahr));
			kelvinField.setText(Double.toString(tempKelvin));
		}
	}
	private class ConvertFahrListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double tempFahr;
			
			try {
				tempFahr = Double.parseDouble(fahrenheitField.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Invalid format");
				return;
			
			}
			
			double tempCelsius = (tempFahr - 32)/1.8;
			double tempKelvin = tempCelsius + 273.15;
			
			celsiusField.setText(Double.toString(tempCelsius));
			kelvinField.setText(Double.toString(tempKelvin));
		}
	}
	private class ConvertKelvinListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double tempKelvin;
			
			try {
				tempKelvin = Double.parseDouble(kelvinField.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Invalid format");
				return;
			
			}
			
			double tempCelsius = tempKelvin - 273.15;
			double tempFahr = tempCelsius*1.8 + 32;
			
			celsiusField.setText(Double.toString(tempCelsius));
			fahrenheitField.setText(Double.toString(tempFahr));
		}
	}
	
	// main program
	public static void main(String[] args) {
		new TemperatureConverter();
	}
}
