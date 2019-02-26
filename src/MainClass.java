import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainClass extends JFrame 
{
	private ArrayList<BankAccount>list = new ArrayList<BankAccount>();

	public MainClass() 
	{
		setBounds(100,100,600,400);
		setLayout(null);
		
		JLabel nameLbl = new JLabel("Name: ");
		nameLbl.setBounds(20,25,200,10);
		add(nameLbl);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(75, 20 , 200, 20);
		add(nameText);
		
		JLabel accountType = new JLabel("Account Type: ");
		accountType.setBounds(20, 70, 200, 20);
		add(accountType);
		
		String[] options = {"", "Checking", "Savings"};
		JComboBox checkingSaving = new JComboBox(options);
		checkingSaving.setBounds(120, 65, 200, 30);
		add(checkingSaving);
		
		JLabel initialBalance = new JLabel("Initial Balance: ");
		initialBalance.setBounds(20, 120, 200, 20);
		add(initialBalance);
		
		JTextField initialText = new JTextField();
		initialText.setBounds(120, 120, 200, 20);
		add(initialText);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(20, 200, 150, 70);
		
		
		createAccount.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					String initialBalance = initialText.getText();
					Double balance = Double.parseDouble(initialBalance);
					
					if(checkingSaving.getSelectedItem().equals("Savings")) 
					{
						BankAccount account = new SavingsAccount(nameText.getText(),balance,0,0,0);
						list.add(account);
					}
					else if(checkingSaving.getSelectedItem().equals("Checking"))
					{
						BankAccount account = new CheckingAccount(nameText.getText(),balance,0,0,0);
						list.add(account);
					}
					
					nameText.setText("");
					initialText.setText("");
					checkingSaving.setSelectedIndex(0);
					
				}
			});
	
		add(createAccount);
		
		JButton display = new JButton("Display Accounts");
		display.setBounds(200, 200, 150, 70);
		
		display.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(BankAccount a: list) 
				{
					System.out.println(a.toString());
				}
			}
		});
		add(display);
		
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new MainClass();

	}

}
