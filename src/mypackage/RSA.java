package mypackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.*;
import java.util.Random;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RSA extends JFrame{
	
	public BigInteger p, q, n, phi, e, d, c;
	int bit_len = 8;
	String text;

	
	public void main2() throws IOException {

		RSA rsa = new RSA();
		gui gui = new gui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(800, 400);
		gui.setVisible(true);
		
        DataInputStream in = new DataInputStream(System.in);

        text = gui.input;		
        text = in.readLine();

		
		byte[] encrypted = rsa.encrypt(text.getBytes());
		byte[] decrypted = rsa.dencrypt(encrypted);

	}

	public RSA() {
		super("Title");
		setLayout(new FlowLayout());

		
		Random r = new Random();
		p = BigInteger.probablePrime(bit_len, r);
		q = BigInteger.probablePrime(bit_len, r);
		
		n = p.multiply(q);
		
		BigInteger pMinus1 = p.subtract(BigInteger.ONE);
		BigInteger qMinus1 = q.subtract(BigInteger.ONE);
		
		phi = pMinus1.multiply(qMinus1);
			
		e = BigInteger.probablePrime(bit_len, r);
		//(e, n) make up the public Key
		
        while (divisor() > 0 && e.compareTo(phi) < 0){
        		e.add(BigInteger.ONE);
        	}
		d = e.modInverse(phi);//private key
	}
	
	public int divisor() {
		return phi.gcd(e).compareTo(BigInteger.ONE);
	}
	
	public static String textToByte(byte[] message) {
		String output ="";
		for(byte i: message) {
			output += Byte.toString(i);
		}
		return output;
	}
	
	public byte[] encrypt(byte[] message) {//get cipher
		BigInteger temp = new BigInteger(message);
		c = temp.modPow(e, n);//public key
		byte[] b = c.toByteArray();
		return b;
	}
	
	public byte[] dencrypt(byte[] message) {
		BigInteger temp = new BigInteger(message);
		BigInteger m = temp.modPow(d, n);//decrypt
		byte[] b = m.toByteArray();
		return b;
	}
		
}
