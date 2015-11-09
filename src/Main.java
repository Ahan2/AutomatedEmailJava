
public class Main {
	static String email = "recipientEmail@email.com"; //enter recipient's email here
	static String name = "Name Of Recipient"; //Enter the name of the recipient here
	public static void main(String args[]){
		//Calling email
        System.out.println("\n***Sending email, please wait....\n");
        SendEmail smtp = new SendEmail(email,name);
        boolean mailSent = smtp.sendRegMail();
	}
}
