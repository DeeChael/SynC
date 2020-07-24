package net.DeeChael.SynC.API;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	
	 public static byte[] toSHA256(String param)
		        throws NoSuchAlgorithmException{
		        byte[] bt = param.getBytes();
		        MessageDigest md = MessageDigest.getInstance("SHA-256");
		        md.update(bt);
		        return md.digest();
		    }

}
