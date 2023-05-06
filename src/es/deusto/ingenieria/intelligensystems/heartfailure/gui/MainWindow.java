package es.deusto.ingenieria.intelligensystems.heartfailure.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import es.deusto.ingenieria.intelligensystems.heartfailure.controller.HeartFailureController;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.ChestPainType;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.RestingElectrocardiogram;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.STSlope;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.Sex;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private HeartFailureController controller;
	
	private ImageIcon errorIcon = new ImageIcon("resources/images/error.png");
	private ImageIcon heartDiseaseIcon = new ImageIcon("resources/images/heartDisease.png");
	private ImageIcon normalIcon = new ImageIcon("resources/images/normal.png");
	
	private JTextField jTextAge = new JTextField();
	private JTextField jTextRestingBloodPressure = new JTextField();
	private JTextField jTextCholesterol = new JTextField();
	private JTextField jTextOldpeak = new JTextField();

	private JComboBox<Sex> jComboSex = new JComboBox<>();
	private JComboBox<RestingElectrocardiogram> jComboRestingECG = new JComboBox<>();
	private JComboBox<ChestPainType> jComboChestPainType = new JComboBox<>();
	private JComboBox<STSlope> jComboStSlope = new JComboBox<>();
	
	private JRadioButton jRadioHasFastingBloodSugar = new JRadioButton("FastingBS > 120 mg/dl");
	private JRadioButton jRadioHasntFastingBloodSugar = new JRadioButton("FastingBS <= 120 mg/dl");	
	private JSpinner jSpinnerMaximumHeartRate = new JSpinner(new SpinnerNumberModel(60, 60, 202, 1));
	private JRadioButton jRadioHasExerciseAngina = new JRadioButton("Yes");
	private JRadioButton jRadioHasntExerciseAngina = new JRadioButton("No");
	
	private JButton jBtnPredict = new JButton("Predict");
	
	public MainWindow(HeartFailureController controller) {
		this.controller = controller;
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new TitledBorder("Patient data"));
		panelMain.setLayout(new GridBagLayout());
		
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);

        List<String> labels = Arrays.asList("Age [years]:", 
        									"Sex:",
        									"Chest Pain Type:",
        									"Resting Blood Pressure [mm Hg]:",
        									"Maximum Heart Rate [BPM]:",
        									"Serum cholesterol [mm/dl]:",
        									"Fasting Blood Sugar:", "",
        									"Resting Electrocardiogram:",        									
        									"Exercise-induced Angina:", "",
        									"ST-Segment Oldpeak:",
        									"ST-Segment Slope:");                
        //Labels
        gbc.gridx = 0; //Column 0
        
        for (int i=0; i < labels.size(); i++) {
        	gbc.gridy = i; //Row 'i'
        	panelMain.add(new JLabel(labels.get(i)), gbc);
        }
                
		//Age  
        gbc.gridx = 1; 	//Column
        gbc.gridy = 0; 	//Row
        gbc.ipadx = 40;	//JTextField width
        jTextAge.setHorizontalAlignment(JLabel.RIGHT);
        panelMain.add(jTextAge, gbc);
		
		//Sex   
		Arrays.asList(Sex.values()).forEach(s -> jComboSex.addItem(s));

        gbc.gridy = 1;
        gbc.ipadx = 0;
        panelMain.add(jComboSex, gbc);

        //Chest Pain Type    
        Arrays.asList(ChestPainType.values()).forEach(c -> jComboChestPainType.addItem(c));
        
        gbc.gridy = 2;
        panelMain.add(jComboChestPainType, gbc);
        
		//Resting blood pressure        
        gbc.gridy = 3;
        gbc.ipadx = 40;
        jTextRestingBloodPressure.setHorizontalAlignment(JLabel.RIGHT);
        panelMain.add(jTextRestingBloodPressure, gbc);
		
		//Maximum Heart Rate
        gbc.gridy = 4;
        gbc.ipadx = 0;
        panelMain.add(jSpinnerMaximumHeartRate, gbc);

		//Cholesterol
        gbc.gridy = 5;
        gbc.ipadx = 40;
        jTextCholesterol.setHorizontalAlignment(JLabel.RIGHT);
        panelMain.add(jTextCholesterol, gbc);

		//Fasting blood sugar
		ButtonGroup rGroupFBS = new ButtonGroup();
		rGroupFBS.add(jRadioHasFastingBloodSugar);
		rGroupFBS.add(jRadioHasntFastingBloodSugar);

        gbc.gridy = 6;
        gbc.ipadx = 0;
        panelMain.add(jRadioHasFastingBloodSugar, gbc);
		gbc.gridy = 7;
        panelMain.add(jRadioHasntFastingBloodSugar, gbc);
        
		//Resting ECG
		Arrays.asList(RestingElectrocardiogram.values()).forEach(r -> jComboRestingECG.addItem(r));

        gbc.gridy = 8;        
        panelMain.add(jComboRestingECG, gbc);
        		
        //Exercise-induced angina
		ButtonGroup rGroupEA = new ButtonGroup();
		rGroupEA.add(jRadioHasExerciseAngina);
		rGroupEA.add(jRadioHasntExerciseAngina);

        gbc.gridy = 9;        
        panelMain.add(jRadioHasExerciseAngina, gbc);
        gbc.gridy = 10;
        panelMain.add(jRadioHasntExerciseAngina, gbc);		
        
        //ST-Segment oldpeak		
        gbc.gridy = 11;
        gbc.ipadx = 40;
        jTextOldpeak.setHorizontalAlignment(JLabel.RIGHT);
        panelMain.add(jTextOldpeak, gbc);
        
		//ST-Segment slope		
		Arrays.asList(STSlope.values()).forEach(c -> jComboStSlope.addItem(c));

        gbc.gridy = 12;
        gbc.ipadx = 0;
        panelMain.add(jComboStSlope, gbc);
        
        
        //Buttom Predict
        jBtnPredict.addActionListener(e -> {
        	predict();
        });
        
        JPanel panelButtom = new JPanel(new BorderLayout(10, 10));       
        panelButtom.add(jBtnPredict, BorderLayout.CENTER);        
        
        JLabel jlabelCredits = new JLabel("<html><a href=\"https://www.flaticon.com/authors/freepik\">Icons created by Freepik - Flaticon</a></html>");
        jlabelCredits.setHorizontalAlignment(JLabel.RIGHT);        
        jlabelCredits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jlabelCredits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.flaticon.com/authors/freepik"));
                } catch (Exception ex) {
                	System.err.println("browser cannot be opened: https://www.flaticon.com/authors/freepik!");
                }
            }
        });
        
        panelButtom.add(jlabelCredits, BorderLayout.SOUTH);
              
		getContentPane().add(panelMain, BorderLayout.CENTER);
		getContentPane().add(panelButtom, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Heart Failure Prediction");
		setIconImage(new ImageIcon("resources/images/logo.png").getImage());		
		setSize(760, 490);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void predict() {
		boolean error = false;
		
		List<String> errors = new ArrayList<String>();
		
		if (jTextAge.getText().isBlank()) {
			errors.add("Age is empty.");
			error = true;
		} else {
			try {
				Short.parseShort(jTextAge.getText());
			} catch (NumberFormatException ex) {
				errors.add("Age is not a number.");
				error = true;
			}
		}
		
		if (((Sex)jComboSex.getSelectedItem()).equals(Sex.U)) {
			errors.add("Sex is Unknown.");
			error = true;			
		}
		
		if(((ChestPainType)jComboChestPainType.getSelectedItem()).equals(ChestPainType.U)) {
			errors.add("Chest pain type is Unknown.");
			error = true;			
		}
		
		if (jTextRestingBloodPressure.getText().isBlank()) {			
			errors.add("Resting blood pressure is empty.");			
			error = true;
		} else {
			try {
				Integer.parseInt(jTextRestingBloodPressure.getText());
			} catch (NumberFormatException ex) {
				errors.add("Resting blood pressure is not a number.");
				error = true;
			}
		}
		
		if (jTextCholesterol.getText().isBlank()) {			
			errors.add("Cholesterol is empty.");
			error = true;
		} else {
			try {
				Integer.parseInt(jTextCholesterol.getText());
			} catch (NumberFormatException ex) {
				errors.add("Cholesterol is not a number.");
				error = true;
			}
		}
		
		if (!jRadioHasFastingBloodSugar.isSelected() && !jRadioHasntFastingBloodSugar.isSelected()) {
			errors.add("Fasting blood sugar is Unknown.");			
			error = true;			
		}
		
		if(((RestingElectrocardiogram)jComboRestingECG.getSelectedItem()).equals(RestingElectrocardiogram.U)) {
			errors.add("Resting ECG is Unknown.");			
			error = true;			
		}
		
		if (!jRadioHasExerciseAngina.isSelected() && !jRadioHasntExerciseAngina.isSelected()) {
			errors.add("Exercise-induced angina is Unknown.");			
			error = true;			
		}

		if (jTextOldpeak.getText().isBlank()) {			
			errors.add("ST-Segment odlpeak empty.");			
			error = true;
		} else {
			try {
				Short.parseShort(jTextOldpeak.getText());
			} catch (NumberFormatException ex) {
				errors.add("ST-Segment odlpeak is not a number.");
				error = true;
			}
		}

		if(((STSlope)jComboStSlope.getSelectedItem()).equals(STSlope.U)) {
			errors.add("ST-Segment slope is Unknown.");			
			error = true;			
		}
		
		if (error) {
			StringBuffer buffer = new StringBuffer();
			
			errors.forEach(e -> {			
				buffer.append("- ");
				buffer.append(e);
				buffer.append("\n");
			});
			
			JOptionPane.showMessageDialog(null, buffer.toString(), "Input error", JOptionPane.ERROR_MESSAGE, errorIcon);
		} else {
			//Invoque the predict method of the controller.
			boolean result = controller.predict(Short.parseShort(jTextAge.getText()),
							   									(Sex)jComboSex.getSelectedItem(),
							   									(ChestPainType)jComboChestPainType.getSelectedItem(),							   
							   									Integer.parseInt(jTextRestingBloodPressure.getText()),
							   									Integer.parseInt(jTextCholesterol.getText()),							   
							   									(jRadioHasFastingBloodSugar.isSelected() ? true : false),
							   									(RestingElectrocardiogram)jComboRestingECG.getSelectedItem(),
							   									(int) jSpinnerMaximumHeartRate.getValue(),					   
							   									(jRadioHasExerciseAngina.isSelected() ? true : false),
							   									Short.parseShort(jTextOldpeak.getText()),
							   									(STSlope)jComboStSlope.getSelectedItem());
			
			if (result) {
				JOptionPane.showMessageDialog(null, "After analysing the patient's information it can be concluded that the person is likely to have heart disease." +
													"\nWe recommend contacting a medical specialist for further analysis of the patient.", 
											  "Prediction result - Possible heart disease", JOptionPane.ERROR_MESSAGE,
											  heartDiseaseIcon);
			} else {
				JOptionPane.showMessageDialog(null, "After analysing the patient's information it can be concluded that the patient's condition is normal. " + 
													"\nTreat this result with caution as this system does not provide a fully conclusive diagnosis. ", 
											  "Prediction result - Absence of heart disease or inconclusive result", JOptionPane.ERROR_MESSAGE,
											  normalIcon);
			}
		}
	}
}