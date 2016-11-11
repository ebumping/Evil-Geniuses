package november;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//import javax.swing.JPasswordField;


public class MyFirstWindow {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private TDB database;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstWindow window = new MyFirstWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. constructor calls init
	 */
	public MyFirstWindow() {
		initialize();
		database = new TDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				User u = new User(firstName.getText(), lastName.getText(),email.getText());
				//database.addUser();
				try {
					database.addUser(u);
				} catch (Exception e1) {					
					e1.printStackTrace();
				}
				for(User x : database.users){
					System.out.println(x);
				}
				//System.out.println(database.users);
				
					//try catch in here
				
			}				/*this method is called when buttons is clicked
							   set the guess					
							  refresh the mask*/
			
			/*action listener
			 * always has action performed
			 * 
			 * this is an inline implementation of ActionListener
			 */
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		firstName = new JTextField();
		firstName.setBounds(96, 11, 86, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(96, 35, 86, 20);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 68, 20);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 38, 78, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 63, 68, 14);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setBounds(96, 60, 86, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Collections.sort(database.users);;
				//for(User x : database.users){
					
				//}
				
			}
		});
		btnSort.setBounds(10, 165, 89, 23);
		frame.getContentPane().add(btnSort);
		
		JButton btnList = new JButton("List");
		btnList.setBounds(10, 199, 89, 23);
		frame.getContentPane().add(btnList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(User u : database.users){
					if (u.getFirstName().equals(firstName.getText()) && u.getLastName().equals(lastName.getText())){
					System.out.println("User found");
					}					
				}
			}
				
		});
		btnSearch.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnSearch);
		
	}
	private void setFields(User user){
		firstName.setText(user.getFirstName());
		lastName.setText(user.getLastName());
		email.setText(user.getEmail());
		
	}
	
}
