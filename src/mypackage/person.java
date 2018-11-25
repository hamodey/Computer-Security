package mypackage;

import java.math.BigInteger;

public class person {
	//server connection
//	server ser = new server();
	RSA rsa = new RSA();
	String message;
	String publicKeyString;
	BigInteger e, n;
	
	person(RSA rsa){
		this.rsa = rsa;
	}
	
	private BigInteger getPriateKey() {
		return rsa.d;
	}
	
	public void setPublicKey() {
//		e = ser.getPublicE();
//		n = ser.getPublicN();
//		
//		publicKeyString = ser.publicKeyToString();
		e = rsa.e;
		n = rsa.n;
		
		System.out.println("(" + e.toString() + ", " + n.toString() + ")");
	}
	
	public BigInteger getPublicE() {
		return e;
	}
	
	public BigInteger getPublicN() {
		return n;
	}
	
	//take message then encrypt
	//send encrypted to other person
	private byte[] encryptMessage() {
		message = rsa.text;
		byte[] encrypted = rsa.encrypt(message.getBytes());
		return encrypted;
	}
	
	private byte[] decryptMessage() {
		byte[] decrypted = rsa.dencrypt(encryptMessage());
		return decrypted;
	}
	
	public byte[] sendMessage() {
		return null;
	}
	
	//get returned public key from partner returned(server s){}
	
	//
	
}
