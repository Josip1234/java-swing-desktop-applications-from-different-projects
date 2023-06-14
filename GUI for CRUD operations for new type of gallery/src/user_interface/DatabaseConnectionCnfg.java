package user_interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.File;
import entities.FileMessages;
import entities.GeneralMessages;
import implementations.DatabaseImpl;
import implementations.FileImplementation;
import implementations.GeneralFunctions;


import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DatabaseConnectionCnfg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424525429913531693L;
	private JPanel contentPane;
	private JTextField driverName;
	private JTextField databaseUrl;
	private JTextField databaseUser;
	private JTextField databasePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnectionCnfg frame = new DatabaseConnectionCnfg();
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
	public DatabaseConnectionCnfg() {
		setResizable(false);
        GeneralFunctions.initApp();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 464);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Home = new JMenu("FIles");
		
			menuBar.add(Home);
			
			JMenuItem ReturnToIndex = new JMenuItem("Return home");
			
				Home.add(ReturnToIndex);
				
				

				
			
		
		JMenu Db = new JMenu("Database");
		menuBar.add(Db);
		
		JMenuItem DatabaseOptions = new JMenuItem("Database connection config");
	
	

	
		Db.add(DatabaseOptions);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(GeneralMessages.welcome);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JLabel LabelForDriver = new JLabel("Insert driver name for database:");
		LabelForDriver.setHorizontalAlignment(SwingConstants.CENTER);
		LabelForDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelForDriver.setVisible(false);
		
		JLabel LabelForDbURL = new JLabel("Insert database URL:");
		LabelForDbURL.setHorizontalAlignment(SwingConstants.CENTER);
		LabelForDbURL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelForDbURL.setVisible(false);
		
		JLabel LabelForDbUser = new JLabel("Insert database user:");
		LabelForDbUser.setHorizontalAlignment(SwingConstants.CENTER);
		LabelForDbUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelForDbUser.setVisible(false);
		
		JLabel LabelForDbUserPass = new JLabel("Insert database password:");
		LabelForDbUserPass.setHorizontalAlignment(SwingConstants.CENTER);
		LabelForDbUserPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelForDbUserPass.setVisible(false);
	
		
	
		
		driverName = new JTextField();
		driverName.setColumns(10);
		driverName.setVisible(false);
		
		databaseUrl = new JTextField();
		databaseUrl.setColumns(10);
		databaseUrl.setVisible(false);
		
		databaseUser = new JTextField();
		databaseUser.setColumns(10);
		databaseUser.setVisible(false);
		
		databasePassword = new JTextField();
		databasePassword.setColumns(10);
		databasePassword.setVisible(false);
		
		JButton btnNewButton = new JButton("Update config");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File();
				DatabaseConnection connection = new DatabaseConnection(driverName.getText(),databaseUrl.getText(),databaseUser.getText(),databasePassword.getText());
		        FileImplementation fileImplementation = new FileImplementation();

		        fileImplementation.writeToAFile(file, connection);

		 
			}
		});
		
		btnNewButton.setVisible(false);
		
		
		ReturnToIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lblNewLabel.setText(GeneralMessages.welcome);
				btnNewButton.setVisible(false);
				databasePassword.setVisible(false);
				databaseUser.setVisible(false);
				databaseUrl.setVisible(false);
				driverName.setVisible(false);
				LabelForDbUserPass.setVisible(false);
				LabelForDbUser.setVisible(false);
				LabelForDbURL.setVisible(false);
				LabelForDriver.setVisible(false);
			}
		});
		
		DatabaseOptions.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        lblNewLabel.setText(DatabaseMessages.databaseConn);
		    				btnNewButton.setVisible(true);
		    				databasePassword.setVisible(true);
		    				databaseUser.setVisible(true);
		    				databaseUrl.setVisible(true);
		    				driverName.setVisible(true);
		    				LabelForDbUserPass.setVisible(true);
		    				LabelForDbUser.setVisible(true);
		    				LabelForDbURL.setVisible(true);
		    				LabelForDriver.setVisible(true);
		    				
		    	DatabaseConnection connection = new DatabaseConnection();
		    	File file = new File();
		    	FileImplementation fileImplementation = new FileImplementation();
		    	if(fileImplementation.checkIfFileExists(file)==true) {
		    		System.out.println(FileMessages.readingFromFile);
		    		
		    		String value=fileImplementation.readFromAFile(file);
		    	    String element=value;
		            element=fileImplementation.parse(element, "JDBC_DRIVER");
		            connection.setJDBC_DRIVER(element);
                    driverName.setText(connection.getJDBC_DRIVER());
                    
                    element=value;
                    element=fileImplementation.parse(element, "DB_URL");
                    connection.setDB_URL(element);
                    databaseUrl.setText(connection.getDB_URL());
                    
                    
                    element=value;
                    element=fileImplementation.parse(element, "USER");
                    connection.setUSER(element);
                    databaseUser.setText(connection.getUSER());
                    
                    
                    element=value;
                    element=fileImplementation.parse(element, "PASS");
                    connection.setPASS(element);
                   databasePassword.setText(connection.getPASS());
                    
		    		System.out.println(FileMessages.finishedReading);
		    	}else {
		    		System.out.println(FileMessages.errorOpeningTheFiles);
		    		System.out.println(FileMessages.fileNotFound);
		    		System.out.println(FileMessages.creatingNewFile);
		    		System.out.println(FileMessages.writingToAFile);
		    		fileImplementation.writeToAFile(file, connection);
		    		System.out.println(FileMessages.fileCreated);
		    	}
		    	
		    	
		    	
			
 			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(LabelForDbUserPass, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
										.addComponent(LabelForDbUser, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(databasePassword, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
										.addComponent(databaseUser, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(LabelForDriver, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(driverName))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(LabelForDbURL, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(databaseUrl, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelForDriver, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(driverName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(databaseUrl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelForDbURL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(databaseUser, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelForDbUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(databasePassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelForDbUserPass, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
