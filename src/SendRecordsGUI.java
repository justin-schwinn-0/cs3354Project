//Gui that allows users to send their records
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SendRecordsGUI implements ActionListener{
	
	//Boolean value for if the user wants to send their records or not and if a button has been pressed
	public boolean wantSendRecords;
	public boolean buttonPressed;
	
	//Frame and Panel
	JFrame SendRecordsFrame;
	JPanel SendRecordsPanel;
	
	//Label for text
	JLabel RecordLabel;
	
	//Buttons
	JButton YesButton;
	JButton NoButton;

	//Constructor
	SendRecordsGUI(){
		
		//Create the frame and panel for our GUI
		SendRecordsFrame = new JFrame("Records Sender");
		SendRecordsFrame.setSize(500, 200);
		SendRecordsPanel = new JPanel();
		SendRecordsPanel.setLayout(null);
		SendRecordsFrame.add(SendRecordsPanel);
		
		//This will allow us to close the frame
		SendRecordsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the label that asks the user if they would like to send their records
		JLabel RecordLabel = new JLabel("Would you like to send your records?");
		RecordLabel.setBounds(150, 25, 500, 50);
		SendRecordsPanel.add(RecordLabel);
		
		//Set up the buttons
		YesButton = new JButton("Yes");
		YesButton.setBounds(50, 100, 80, 20);
		YesButton.addActionListener(this);
		NoButton = new JButton("No");
		NoButton.addActionListener(this);
		NoButton.setBounds(400, 100, 80, 20);
		SendRecordsPanel.add(YesButton);
		SendRecordsPanel.add(NoButton);
		
		SendRecordsFrame.setVisible(true);
		
		
	}

	//This will determine which button has been pressed and act accordingly, it will determine which
	//Button has been pressed and act accordingly. We will take advantage of the ActionEvent's getSource
	//method to find out which button has been pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//If the yes button has been pressed, set the wantsSendRecords value to true and remove the frame
		if(e.getSource() == YesButton) {
			wantSendRecords = true;
			//SendRecordsFrame.setVisible(false);
			SendRecordsFrame.dispose();
			buttonPressed = true;

		}
		
		//If the no button is pressed, just remove the frame
		else if (e.getSource() == NoButton) {
			//SendRecordsFrame.setVisible(false);
			SendRecordsFrame.dispose();
			buttonPressed = true;
		}

		System.out.println("wantsSendRecords = " + wantSendRecords);

		
	}
	
}
