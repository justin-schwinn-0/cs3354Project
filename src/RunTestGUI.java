import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Gui that allows the user to run tests, user will input the value type, test type, iterations, and trial
public class RunTestGUI implements ActionListener{
	
	//Strings that our inputs will be put into
	String valueType;
	String testType;
	String iterations;
	String trials;
	
	//String array that holds our options for the test type
	String[] tests = {"Addition", "Subtraction", "Multiplication", "Division"};
	
	//Frame and Panel
	JFrame RunTestFrame;
	JPanel RunTestPanel;
	
	//Labels for text
	JLabel valueLabel;
	JLabel testLabel;
	JLabel iterLabel;
	JLabel trialsLabel;
	
	//Buttons
	JButton submitButton;
	
	//Radio Buttons
	JRadioButton intButton;
	JRadioButton floatButton;
	
	//Button Group
	ButtonGroup buttonGroup;
	
	//Drop down box
	JComboBox testList;
	
	//Text boxes
	JTextField iterField;
	JTextField trialField;
	
	//Bool value to see if both of our inputs are valid
	boolean isValid;
	
	//Constructor
	RunTestGUI(){
				
		//Set isValid to true by default
		isValid = true;
		
		//Create the frame and panel for our GUI
		RunTestFrame = new JFrame("Run Test");
		RunTestFrame.setSize(500,500);
		RunTestPanel = new JPanel();
		RunTestPanel.setLayout(null);
		RunTestFrame.add(RunTestPanel);
		
		//This will allow us to close the frame
		RunTestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the labels, buttons, and text boxes
		valueLabel = new JLabel("Value type:");
		valueLabel.setBounds(50, 50, 100, 50);
		RunTestPanel.add(valueLabel);
		

		
		//Set up the buttons for the button group (these are for the value types)
		intButton = new JRadioButton("Integer");
		intButton.setBounds(150, 50, 100, 50);
		RunTestPanel.add(intButton);
		floatButton = new JRadioButton("Float");
		floatButton.setBounds(250, 50, 100, 50);
		RunTestPanel.add(floatButton);
		
		//Set up the button group for the value types, and add the radio buttons to it
		buttonGroup = new ButtonGroup();
		buttonGroup.add(intButton);
		buttonGroup.add(floatButton);
		
		//Set up label above drop down box
		testLabel = new JLabel("Test type:");
		testLabel.setBounds(200, 75, 100, 50);
		RunTestPanel.add(testLabel);
		
		//Set up the combobox in that holds the possible test types
		testList = new JComboBox(tests);
		RunTestPanel.add(testList);
		testList.setBounds(200, 100, 100, 50);
		
		//Set up the label and text box for the number of iterations
		iterLabel = new JLabel("Number of interations:");
		iterLabel.setBounds(50, 150, 200, 50);
		RunTestPanel.add(iterLabel);
		iterField = new JTextField();
		iterField.setBounds(200, 165, 200, 25);
		RunTestPanel.add(iterField);
		
		//Set up the label and text box for the number of trials
		trialsLabel = new JLabel("Number of trials:");
		trialsLabel.setBounds(50, 200, 200, 50);
		RunTestPanel.add(trialsLabel);
		trialField = new JTextField();
		trialField.setBounds(200, 215, 200, 25);
		RunTestPanel.add(trialField);
		
		//Set up submit button
		submitButton = new JButton("Begin Test");
		submitButton.setBounds(200, 265, 100, 50);
		RunTestPanel.add(submitButton);
		
		//Add an action listener to our submit button
		submitButton.addActionListener(this);
		
		RunTestFrame.setVisible(true);
	}

	//This gets run whenever the submit button is clicked. We will check to see if the 
	//inputs in the text boxes are integers, if so, set all the string values and print them
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Set all the string values, start with the data type
		if(intButton.isSelected() == true) {
			valueType = "i";
		}
		
		else if(floatButton.isSelected() == true) {
			valueType = "f";
		}
		
		//Nothing is selected, is not valid
		else {
			isValid = false;
		}
		
		//Now work on the drop down box
		testType = tests[testList.getSelectedIndex()];
		
		//Now use a for loop to check the input for the iterations box, set isValid to false if 
		//it is not all digits
		iterations = iterField.getText();
		
		//For loop, if character is not digit set isValid to false
		for(int i = 0; i < iterations.length() - 1; i++) {
			
			//Use the isDigit method to determine if it is a number or not
			if(Character.isDigit(iterations.charAt(i)) == false) {
				isValid = false;
			}
		}
		
		//Finally, do the same for the trials
		trials = trialField.getText();
		
		//For loop, if character is not digit set isValid to false
		for(int i = 0; i < trials.length() - 1; i++) {
			
			//Use the isDigit method to determine if it is a number or not
			if(Character.isDigit(trials.charAt(i)) == false) {
				isValid = false;
			}
		}
		
		//System.out.println(isValid);
		//If isValid is still true, print all of the string values. Print an error message otherwise
		if(isValid == true) {
			System.out.println(valueType);
			System.out.println(testType);
			System.out.println(iterations);
			System.out.println(trials);
		}
		
		else {
			System.out.println("Error. Please input correct parameters");
			
			//Reset isValid to allow for more attempts
			isValid = true;
		}
	}
	
	//

}
