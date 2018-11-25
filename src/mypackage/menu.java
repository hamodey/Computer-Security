package mypackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.*;
import java.util.Random;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu {

	public static void main(String[] args) throws IOException {
		System.out.println(new server().publicKeyToString());
		
		new RSA().main2();	
	}
	
}
