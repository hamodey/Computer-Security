package mypackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class gui extends JFrame{

	private JLabel openMsg;
	private JLabel endMsg;
	private JLabel msgAsNo;
	private JLabel dmsgAsNo;
	private JLabel fullyEnd;
	private JLabel correct;
	private JLabel incorrect;
	private JLabel cipher;
	private JPanel jp = new JPanel();
	private JTextField jt = new JTextField(40);
	public String input;
	
	public gui() {
		// TODO Auto-generated constructor stub
		super("RSA Algorithm by Ahmed, Taha & Fuad");
		RSA rsa = new RSA();
		setLayout(new FlowLayout());
		
		openMsg = new JLabel("Please enter your message (max 32 char): ");
		openMsg.setToolTipText("Enter message you wish to encrypt");
		endMsg = new JLabel("");
		msgAsNo = new JLabel("");
		dmsgAsNo = new JLabel("");
		fullyEnd = new JLabel("");
		correct = new JLabel("");
		incorrect = new JLabel("");
		cipher = new JLabel("");
		
		
		jt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = jt.getText();
				byte[] encrypted = rsa.encrypt(input.getBytes());
				byte[] decrypted = rsa.dencrypt(encrypted);
				
				
//				msgAsNo.setText("Your text as number: " + rsa.textToByte(encrypted));
				dmsgAsNo.setText("Your decrpyted text as number: " + rsa.textToByte(decrypted) + "\n");

				endMsg.setText("Your message was " + input + "\n");
				cipher.setText("Your cipher text is : " + new String(encrypted));
				fullyEnd.setText("Your message decrypted is " + new String(decrypted)+ "\n");

				if(input.equals(new String(decrypted))) {
					correct.setText("CORRECT!");
					incorrect.setText("");
					correct.setForeground(Color.green);
				}else {
					incorrect.setText("INCORRECT! :(");
					correct.setText("");
					incorrect.setForeground(Color.red);
				}
			}
		});
		
		add(openMsg);//open message
		add(jt);//input field
		add(endMsg);//what we put
		add(msgAsNo);//number
		add(dmsgAsNo);//d number
		add(fullyEnd);//fully finished decryted msg
		add(correct);
		add(incorrect);
		add(cipher);
	}

}
