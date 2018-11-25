package mypackage;

import java.math.BigInteger;

public class server {
	//get public key
	public RSA rsa = new RSA();
	public BigInteger e, n;
	//new people/connection
	person alice = new person(rsa);
	person bob = new person(rsa);
	
	server(){
		//constructor
		alice.setPublicKey();
		bob.setPublicKey();
	}

	//get e
	public BigInteger getPublicE(person p) {
		return p.getPublicE();
	}

	//get n
	public BigInteger getPublicN(person p) {
		return p.getPublicN();
	}	
	
	//public key to string so readable
	public String publicKeyToString() {
		String e = rsa.e.toString();
		String n = rsa.n.toString();
		
		return "(" + e + ", " + n + ")";
	}
	
	//return public key
}
