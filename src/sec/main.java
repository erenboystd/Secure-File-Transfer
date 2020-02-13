package sec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.file.Files;

public class main {

	
    public static void main(String[] args) throws Exception
    {
    	AES AES = new AES();
    	MD5 MD5 = new MD5();
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//String c = in.readLine();
    	while(true){
    		System.out.println("Enter 1 for Confidentiality\nEnter 2 for Authentication\nEnter 3 for check Authentication"
    				+ "\nEnter 0 for exit ");
    		String c = in.readLine();
	    	if(c.equals("1")){
	    		System.out.println(" Enter 1 for encryption\n Enter 2 for the decryption");
	    		c = in.readLine();
	    		if(c.equals("1")){
			    	System.out.println("Enter the key file : ");
			    	String filename = in.readLine();
			    	File file = new File(filename);
			    	byte[] secretKey = Files.readAllBytes(file.toPath());
			    			
			    	System.out.println("Enter the file that will be encrypt");
			    	
			    	filename = in.readLine();
			    	File file_e = new File(filename);
			    	byte[] originalString = Files.readAllBytes(file_e.toPath());
			        
			        byte[] encryptedString = AES.encrypt(originalString, secretKey);
			        
			        FileOutputStream s = new FileOutputStream("cipher.txt");
			        s.write(encryptedString);
			        s.close();
			        System.out.println(" cipher.txt created");
	    		}
	    		else if(c.equals("2")){
	    			System.out.println("Enter the key file : ");
			    	String filename = in.readLine();
			    	File file = new File(filename);
			    	byte[] secretKey = Files.readAllBytes(file.toPath());
	    			System.out.println("Enter the file that will be decrypt");    
			    	filename = in.readLine();
			    	File file_d = new File(filename);
			    	byte[] encryptedString = Files.readAllBytes(file_d.toPath());
			    	
			        byte[] decryptedString = AES.decrypt(encryptedString, secretKey) ;
			        
			        FileOutputStream sc = new FileOutputStream("output.txt");
			        sc.write(decryptedString);
			        System.out.println(" output.txt created");
	    		}
	    	}
	        
	    	else if(c.equals("2")){
		        System.out.println("Enter the filename for hashing : ");
		    	String filename = in.readLine();
		    	File file = new File(filename);
		    	
		        byte[] passwordToHash = Files.readAllBytes(file.toPath());
		        String ps = new String(passwordToHash);
		        
		        BufferedWriter s = new BufferedWriter(new FileWriter("cipherHash.txt"));
		        String generatedPassword = MD5.hashing(ps);
		        s.write(generatedPassword);
		        s.close();
		        System.out.println(" cipherHash created");
		        
	    	}
	    	else if(c.equals("3")){
		        System.out.println("Enter the filename to check : ");
		    	String filename = in.readLine();
		    	File file = new File(filename);
		    	
		        byte[] passwordToHash = Files.readAllBytes(file.toPath());
		        String ps = new String(passwordToHash);
		        String first = MD5.hashing(ps);
		        
		        File file_exist = new File("cipherHash.txt");
		        byte[] passwordToHash2 = Files.readAllBytes(file_exist.toPath());
		        String ps2 = new String(passwordToHash2);
		        String second = ps2;
	    	
		        if(first.equals(second)){
		        	System.out.println("Correct File");
		        }
		        else 
		        	System.out.println("Wrong File");
		        
	    	}
	    	else if(c.equals("0"))
	    		break;
    	}
        /*System.out.println(new String(originalString));
        System.out.println(new String(encryptedString));
        System.out.println(new String(decryptedString));*/
        
        
        //enc yapacak dosyanın pathini kendi girsin...
        //cipher txt adını kendi girsin..
	}

}
