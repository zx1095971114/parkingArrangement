package parkinginall;
import parkinginall.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Preparing extends Judge{
	public String path = "carReady";
	public String carid = null;
	    public static void preparing(String order1)
	    {
	    	try {
				while(order1 == "in"){
					carid = path.judge();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    	
	    }
	    public String cardid()
	    {
	    	String idprepared = null;
	    	try {
	    		idprepared = carid;

	        	while(carid != null)
	        	{
	        		ReadFile.read(idprepared);
	        	}
	        	
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return idprepared;
	    }
	   
	     

}
