package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FrontEnd;
import Controller.PatientHelper;
import Model.Node;
import Model.Patient;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class AppGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private FrontEnd frontEnd = new FrontEnd();
	private PatientHelper ph = new PatientHelper();
	private JPanel panelMainMenu;
	private JPanel panelExistingPatient;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField txtPhone;
	private JPanel panelNewPatient;
	private JPanel panelDoctorView;
	private JTextPane textPaneQueue;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI frame = new AppGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public AppGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelMainMenu = new JPanel();
		layeredPane.add(panelMainMenu, "name_205813530699701");
		GridBagLayout gbl_panelMainMenu = new GridBagLayout();
		gbl_panelMainMenu.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelMainMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelMainMenu.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMainMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMainMenu.setLayout(gbl_panelMainMenu);
		
		JPanel panelExistingPatient = new JPanel();
		layeredPane.add(panelExistingPatient, "name_205816430372138");
		GridBagLayout gbl_panelExistingPatient = new GridBagLayout();
		gbl_panelExistingPatient.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelExistingPatient.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelExistingPatient.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelExistingPatient.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelExistingPatient.setLayout(gbl_panelExistingPatient);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 3;
		gbc_lblWelcome.gridy = 1;
		panelMainMenu.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Click on button that corresponds to you:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		panelMainMenu.add(lblNewLabel, gbc_lblNewLabel);
		
//-------------------------------- Existing Patient Button ----------------------------------------------		
		JButton btnExistingPatient = new JButton("Existing Patient");
		btnExistingPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelExistingPatient.setVisible(true);
				panelMainMenu.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnExistingPatient = new GridBagConstraints();
		gbc_btnExistingPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnExistingPatient.gridx = 3;
		gbc_btnExistingPatient.gridy = 3;
		panelMainMenu.add(btnExistingPatient, gbc_btnExistingPatient);

//-------------------------------- New Patient Button ----------------------------------------------		
		JButton btnNewPatient = new JButton("New Patient");
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewPatient.setVisible(true);
				panelMainMenu.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewPatient = new GridBagConstraints();
		gbc_btnNewPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewPatient.gridx = 3;
		gbc_btnNewPatient.gridy = 4;
		panelMainMenu.add(btnNewPatient, gbc_btnNewPatient);

//-------------------------------- Doctor Button ----------------------------------------------		
		JButton btnDoctorview = new JButton("DoctorView");
		btnDoctorview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prep Doctor window by filling out text pane
				List<Node> q = frontEnd.getQList();
				String list = "";
				
				for (int i = 0; i < q.size(); i++) {
					list += q.get(i).toString() + "\n";
				}
				
				textPaneQueue.setText(list);
				
				panelDoctorView.setVisible(true);
				panelMainMenu.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_btnDoctorview = new GridBagConstraints();
		gbc_btnDoctorview.insets = new Insets(0, 0, 0, 5);
		gbc_btnDoctorview.gridx = 3;
		gbc_btnDoctorview.gridy = 8;
		panelMainMenu.add(btnDoctorview, gbc_btnDoctorview);
		
		
		
		JLabel lblEnterFirstName = new JLabel("Enter first name:");
		GridBagConstraints gbc_lblEnterFirstName = new GridBagConstraints();
		gbc_lblEnterFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblEnterFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterFirstName.gridx = 2;
		gbc_lblEnterFirstName.gridy = 1;
		panelExistingPatient.add(lblEnterFirstName, gbc_lblEnterFirstName);
		
		txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFName.gridx = 3;
		gbc_txtFName.gridy = 1;
		panelExistingPatient.add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblEnterLastName = new JLabel("Enter last name:");
		GridBagConstraints gbc_lblEnterLastName = new GridBagConstraints();
		gbc_lblEnterLastName.anchor = GridBagConstraints.EAST;
		gbc_lblEnterLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterLastName.gridx = 2;
		gbc_lblEnterLastName.gridy = 2;
		panelExistingPatient.add(lblEnterLastName, gbc_lblEnterLastName);
		
		txtLName = new JTextField();
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLName.anchor = GridBagConstraints.NORTH;
		gbc_txtLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLName.gridx = 3;
		gbc_txtLName.gridy = 2;
		panelExistingPatient.add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel lblmaximunMinimum = new JLabel("(Maximun - Minimum)");
		GridBagConstraints gbc_lblmaximunMinimum = new GridBagConstraints();
		gbc_lblmaximunMinimum.insets = new Insets(0, 0, 5, 0);
		gbc_lblmaximunMinimum.gridx = 3;
		gbc_lblmaximunMinimum.gridy = 4;
		panelExistingPatient.add(lblmaximunMinimum, gbc_lblmaximunMinimum);
		
		JLabel lblEmergencyRating = new JLabel("Emergency Rating:");
		GridBagConstraints gbc_lblEmergencyRating = new GridBagConstraints();
		gbc_lblEmergencyRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmergencyRating.gridx = 2;
		gbc_lblEmergencyRating.gridy = 5;
		panelExistingPatient.add(lblEmergencyRating, gbc_lblEmergencyRating);
		
		JSlider sliderPriority = new JSlider();
		sliderPriority.setSnapToTicks(true);
		sliderPriority.setMajorTickSpacing(10);
		sliderPriority.setPaintTicks(true);
		GridBagConstraints gbc_sliderPriority = new GridBagConstraints();
		gbc_sliderPriority.insets = new Insets(0, 0, 5, 0);
		gbc_sliderPriority.gridx = 3;
		gbc_sliderPriority.gridy = 5;
		panelExistingPatient.add(sliderPriority, gbc_sliderPriority);

//-------------------------------- Check In Button ----------------------------------------------		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search for the patient
				PatientHelper ph = new PatientHelper();
				Patient found = ph.searchForPatientByName(txtFName.getText() , txtLName.getText());
				
				//Check in patient into queue
				if(found != null) {
					
					int priority = sliderPriority.getValue();
					frontEnd.addToQ(found, priority);
					JOptionPane.showMessageDialog(null, "Checked in!");
					
					//reset text fields
					txtFName.setText("");
					txtLName.setText("");
					
					//return to main menu
					panelMainMenu.setVisible(true);
					panelExistingPatient.setVisible(false);
				}
				// if not found print out invalid user patient
				else JOptionPane.showMessageDialog(null, "Invalid Patient");
			}
		});
		GridBagConstraints gbc_btnCheckIn = new GridBagConstraints();
		gbc_btnCheckIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckIn.gridx = 2;
		gbc_btnCheckIn.gridy = 7;
		panelExistingPatient.add(btnCheckIn, gbc_btnCheckIn);
		
//-------------------------------- Edit Button ----------------------------------------------		
		JButton btnEditRecords = new JButton("Edit Records");
		GridBagConstraints gbc_btnEditRecords = new GridBagConstraints();
		gbc_btnEditRecords.gridx = 3;
		gbc_btnEditRecords.gridy = 7;
		panelExistingPatient.add(btnEditRecords, gbc_btnEditRecords);
		
		panelNewPatient = new JPanel();
		layeredPane.add(panelNewPatient, "name_208354560932651");
		GridBagLayout gbl_panelNewPatient = new GridBagLayout();
		gbl_panelNewPatient.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelNewPatient.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNewPatient.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelNewPatient.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNewPatient.setLayout(gbl_panelNewPatient);
		
		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 1;
		panelNewPatient.add(lblFirstName, gbc_lblFirstName);
		
		textFName = new JTextField();
		GridBagConstraints gbc_textFName = new GridBagConstraints();
		gbc_textFName.insets = new Insets(0, 0, 5, 0);
		gbc_textFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFName.gridx = 2;
		gbc_textFName.gridy = 1;
		panelNewPatient.add(textFName, gbc_textFName);
		textFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 2;
		panelNewPatient.add(lblLastName, gbc_lblLastName);
		
		textLName = new JTextField();
		GridBagConstraints gbc_textLName = new GridBagConstraints();
		gbc_textLName.insets = new Insets(0, 0, 5, 0);
		gbc_textLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLName.gridx = 2;
		gbc_textLName.gridy = 2;
		panelNewPatient.add(textLName, gbc_textLName);
		textLName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 3;
		panelNewPatient.add(lblAge, gbc_lblAge);
		
		JSpinner spinnerAge = new JSpinner();
		GridBagConstraints gbc_spinnerAge = new GridBagConstraints();
		gbc_spinnerAge.anchor = GridBagConstraints.WEST;
		gbc_spinnerAge.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerAge.gridx = 2;
		gbc_spinnerAge.gridy = 3;
		panelNewPatient.add(spinnerAge, gbc_spinnerAge);
		
		JLabel lblHeightInCm = new JLabel("Height in CM:");
		GridBagConstraints gbc_lblHeightInCm = new GridBagConstraints();
		gbc_lblHeightInCm.anchor = GridBagConstraints.EAST;
		gbc_lblHeightInCm.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightInCm.gridx = 1;
		gbc_lblHeightInCm.gridy = 4;
		panelNewPatient.add(lblHeightInCm, gbc_lblHeightInCm);
		
		JSpinner spinnerHeight = new JSpinner();
		GridBagConstraints gbc_spinnerHeight = new GridBagConstraints();
		gbc_spinnerHeight.anchor = GridBagConstraints.WEST;
		gbc_spinnerHeight.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerHeight.gridx = 2;
		gbc_spinnerHeight.gridy = 4;
		panelNewPatient.add(spinnerHeight, gbc_spinnerHeight);
		
		JLabel lblPhone = new JLabel("Phone (just numbers:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 5;
		panelNewPatient.add(lblPhone, gbc_lblPhone);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 2;
		gbc_txtPhone.gridy = 5;
		panelNewPatient.add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblInsured = new JLabel("Insured:");
		GridBagConstraints gbc_lblInsured = new GridBagConstraints();
		gbc_lblInsured.anchor = GridBagConstraints.EAST;
		gbc_lblInsured.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsured.gridx = 1;
		gbc_lblInsured.gridy = 6;
		panelNewPatient.add(lblInsured, gbc_lblInsured);
		
		JToggleButton tglbtnInsured = new JToggleButton("No");
		tglbtnInsured.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnInsured.isSelected()) {
					tglbtnInsured.setText("Yes");
				}
				else {
					tglbtnInsured.setText("No");
				}
			}
		});
		GridBagConstraints gbc_tglbtnInsured = new GridBagConstraints();
		gbc_tglbtnInsured.anchor = GridBagConstraints.WEST;
		gbc_tglbtnInsured.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnInsured.gridx = 2;
		gbc_tglbtnInsured.gridy = 6;
		panelNewPatient.add(tglbtnInsured, gbc_tglbtnInsured);
		
		JLabel lblBlood = new JLabel("Blood Type:");
		GridBagConstraints gbc_lblBlood = new GridBagConstraints();
		gbc_lblBlood.anchor = GridBagConstraints.EAST;
		gbc_lblBlood.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlood.gridx = 1;
		gbc_lblBlood.gridy = 7;
		panelNewPatient.add(lblBlood, gbc_lblBlood);
		
		JComboBox comboBoxBlood = new JComboBox();
		comboBoxBlood.setModel(new DefaultComboBoxModel(new String[] {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"}));
		GridBagConstraints gbc_comboBoxBlood = new GridBagConstraints();
		gbc_comboBoxBlood.anchor = GridBagConstraints.WEST;
		gbc_comboBoxBlood.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxBlood.gridx = 2;
		gbc_comboBoxBlood.gridy = 7;
		panelNewPatient.add(comboBoxBlood, gbc_comboBoxBlood);

//-------------------------------- Register Button ----------------------------------------------		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Create new Patient Object
				Patient newPatient = new Patient(textFName.getText(),
						textLName.getText(),
						(int)spinnerAge.getValue(),
						(int)spinnerHeight.getValue(),
						txtPhone.getText(),
						tglbtnInsured.getModel().isSelected(),
						comboBoxBlood.getSelectedItem().toString());
				
				// insert
				ph.insertPatient(newPatient);

				//exit
				JOptionPane.showMessageDialog(null, "Registered Successfully!");
				panelMainMenu.setVisible(true);
				panelNewPatient.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 1;
		gbc_btnRegister.gridy = 8;
		panelNewPatient.add(btnRegister, gbc_btnRegister);
		
//-------------------------------- Return Button ----------------------------------------------		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainMenu.setVisible(true);
				panelNewPatient.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.gridx = 2;
		gbc_btnReturn.gridy = 8;
		panelNewPatient.add(btnReturn, gbc_btnReturn);
		
		panelDoctorView = new JPanel();
		layeredPane.add(panelDoctorView, "name_215465109484815");
		GridBagLayout gbl_panelDoctorView = new GridBagLayout();
		gbl_panelDoctorView.columnWidths = new int[]{0, 0};
		gbl_panelDoctorView.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDoctorView.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDoctorView.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDoctorView.setLayout(gbl_panelDoctorView);
		
		JLabel lblQueue = new JLabel("Queue:");
		GridBagConstraints gbc_lblQueue = new GridBagConstraints();
		gbc_lblQueue.insets = new Insets(0, 0, 5, 0);
		gbc_lblQueue.gridx = 0;
		gbc_lblQueue.gridy = 0;
		panelDoctorView.add(lblQueue, gbc_lblQueue);
		
		textPaneQueue = new JTextPane();
		textPaneQueue.setEditable(false);
		GridBagConstraints gbc_textPaneQueue = new GridBagConstraints();
		gbc_textPaneQueue.gridheight = 6;
		gbc_textPaneQueue.insets = new Insets(0, 0, 5, 0);
		gbc_textPaneQueue.fill = GridBagConstraints.BOTH;
		gbc_textPaneQueue.gridx = 0;
		gbc_textPaneQueue.gridy = 1;
		panelDoctorView.add(textPaneQueue, gbc_textPaneQueue);

//-------------------------------- Return Button ----------------------------------------------		
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frontEnd.dequeue();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Queue is empty.");
				}
				//prep Doctor window by filling out text pane
				List<Node> q = frontEnd.getQList();
				String list = "";
				for (int i = 0; i < q.size(); i++) {
					list += q.get(i).toString() + "\n\n";
				}
				System.out.println(list);
				textPaneQueue.setText(list);
			}
		});
		GridBagConstraints gbc_btnDequeue = new GridBagConstraints();
		gbc_btnDequeue.insets = new Insets(0, 0, 5, 0);
		gbc_btnDequeue.gridx = 0;
		gbc_btnDequeue.gridy = 7;
		panelDoctorView.add(btnDequeue, gbc_btnDequeue);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainMenu.setVisible(true);
				panelDoctorView.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnMainMenu = new GridBagConstraints();
		gbc_btnMainMenu.gridx = 0;
		gbc_btnMainMenu.gridy = 8;
		panelDoctorView.add(btnMainMenu, gbc_btnMainMenu);
		
		
	}
	
}
