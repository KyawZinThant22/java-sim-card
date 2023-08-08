package simcard;

import java.util.Scanner;

public class SimCard {
	public String phone;
	public String owner;
	public int bill;
	public boolean swe;
	public String type;
	static int noOfPhone = 0;
	
	static String gsm1000[] = {"0" ,"3", "4" };
	static String gsm3000[] = {"7" ,"3", "4" };
	static String gsm5000[] = {"2" ,"3", "2" };
	
	static String mpt1000[] = {"2" ,"1", "4" };
	static String mpt3000[] = {"2" ,"8", "4" };
	static String mpt5000[] = {"2" ,"9", "4" }; 
	
	static Scanner sc = new Scanner(System.in);
	
	public SimCard(String no , String owner , String type) {
		this.phone = no;
		this.owner = owner;
		this.swe = false;
		this.type = type;
		noOfPhone++;
		this.bill = 300;
	}
	
	public void buySwe() {
		this.swe = true;
	}
	
	public void removeSwe() {
		this.swe = false;
	}
	
	public void phoneCall(int second) {
		
		  int hours = second / 3600;
	      int remainingSecondsAfterHours = second % 3600;
	      int minutes = remainingSecondsAfterHours / 60;
	      int seconds = remainingSecondsAfterHours % 60;
	      
		double totalbalance = 0;
		if (this.swe) {
			totalbalance = (second / 60 ) * 13;
		}else {
			totalbalance = ( second / 60) * 25;
		}
		
		this.bill -= totalbalance;
		
		System.out.println("You call for " + hours + " hour " + minutes + " minutes " + seconds + " seconds ");
		System.out.println("Its cost " + totalbalance + " kyats ");
		System.out.println("Your remainging balance is " + this.bill);
	}
	
	public void useInternet( int amount , int second) {

		  int hours = second / 3600;
	      int remainingSecondsAfterHours = second % 3600;
	      int minutes = remainingSecondsAfterHours / 60;
	      int seconds = remainingSecondsAfterHours % 60;
	      
	      double totalAmount = 0;
	      
	      if ( this.swe) {
	    	  	totalAmount = amount * 6;
	      }else {
	    	  if ( this.type.equals("WCDMA")) {
	    		  totalAmount = ( second / 60) * 4;
	    	  }else {
	    		  totalAmount = ( second / 60) * 2;
	    	  }
	      }
	      
	  	
			this.bill -= totalAmount;
	      
	  	System.out.println("You use internet for " + hours + " hour " + minutes + " minutes " + seconds + " seconds ");
	    System.out.println("Its cost " + totalAmount + " kyats ");
	  	System.out.println("Your remainging balance is " + this.bill);
	}
	
	public void Display(String arr[]) {
		for ( int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void isMPTPinCorrect (String pin[], String code[],int amount) {
		 boolean allMatch = true;
		for ( int i = 0 ; i < pin.length ; i++) {
			if ( !code[i].equals(pin[i])) {
				 allMatch = false;
	              break;	
			}
		}
		
		if (allMatch) {
            for (int i = 0; i < code.length; i++) {
                code[i] = "";
            }
            
            this.bill += amount;
        }
		
		if ( allMatch) {
			System.out.println("You have successfully top up MPT " + amount + " kyats ");
			System.out.println("Your total balance is " + this.bill);
		}
		
	}
	
	public void isGSMPinCorrect (String pin[], String code[], int amount) {
		 boolean allMatch = true;
		for ( int i = 0 ; i < pin.length ; i++) {
			if ( !code[i].equals(pin[i])) {
				 allMatch = false;
	              break;	
			}
		}
		
		if (allMatch) {
           for (int i = 0; i < code.length; i++) {
               code[i] = "";
           }
           
           this.bill += amount;
       }
		
		if ( allMatch) {
			System.out.println("You have successfully top up GSM " + amount + " kyats ");
			System.out.println("Your total balance is " + this.bill);
		}
		
	}
	
	public void fillbill() {
		
		String pin[] = new String[3];
		
		int i = 0;
		
		while ( i <= 2) {
			System.out.print("Enter pin: ");
			pin[i] = sc.nextLine();
			i++;
		}
		
		if (this.type.equals("MPT")) {
			isMPTPinCorrect(pin,mpt1000, 1000);
			isMPTPinCorrect(pin,mpt3000, 3000);
			isMPTPinCorrect(pin,mpt5000, 5000);
		}else if ( this.type.equals("GSM")) {
			isGSMPinCorrect(pin,gsm1000,1000);
			isGSMPinCorrect(pin,gsm3000,3000);
			isGSMPinCorrect(pin,gsm5000,5000);
		}else {
			System.out.println("Wrong pin number");
		}
	}	
}
