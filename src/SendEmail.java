import java.net.*;
import java.io.*;
import java.util.*;

public class SendEmail {
    private final static String EMAIL_MESSAGE = "This is a test email agent!";
    private String rec_email;
    private String rec_name;
    
    /*public static void main(String[] args) {
        SendEmail smtp = new SendEmail(args[0],args[1],args[2]);
        smtp.sendMail();
    }*/
    
     public SendEmail(String rec_email, String rec_name){  
        this.rec_email = rec_email;
        this.rec_name = rec_name;
    }

    String line;
    String response;
    private OutputStream os;
    private PrintWriter out;
    private BufferedReader in;


    public boolean sendRegMail() {
        try {
            Socket s = new Socket("your.smtp.server", 25);//ENTER YOUR SMTP SERVER
            out = new PrintWriter(s.getOutputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            String hostName = InetAddress.getLocalHost().getHostName();
            //System.out.println("hostName = " + hostName);
            send(null);
            Thread.sleep(1000);
            send("HELO " + hostName);
            Thread.sleep(1000);
            send("AUTH LOGIN");
            Thread.sleep(1000);
            send("");//IMPORTANT: ENTER YOUR AUTH LOGIN IN HERE IN BASE64
            Thread.sleep(1000);
            send("");//IN BASE64
            Thread.sleep(1000);
            send("MAIL FROM:" + "<youremail@email.com>");//YOUR EMAIL
            Thread.sleep(1000);
            send("RCPT TO:<" + rec_email + ">");
            send("RCPT TO:" + "<otheremail@gmail.com>");//other recipients (optional)
            Thread.sleep(1000);
            send("DATA");
            Thread.sleep(1000);
            // out.println("Date: Sun, 28 June 2015 10:23:00 +0530");
            out.println("" + (new Date()));
            out.println("From: Your Name <youremail@email.com>");//IMPORTANT: REMEMBER TO FOLLOW THE EXACT FORMAT OF THE EMAIL WILL NOT SEND
            out.println("Subject: Subject Here");
            out.println("To: " + rec_email);
            out.println("");
            out.println("Hello " + rec_name + " content of email"); //CONTENT OF YOUR EMAIL
            out.flush();
            Thread.sleep(1000);
            out.println(".");
            out.flush();
            if ((line = in.readLine()) != null) // output the response
                System.out.println(line);
            out.println("QUIT");
            out.flush();
            if ((line = in.readLine()) != null) // output the response
                System.out.println(line);

            s.close();
            out.close();
            in.close();
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("\n***Unable to send email. You need to ensure you're connected to the internet.");
            System.out.println("\nPlease wait while the application reloads...");
            try{
                Thread.sleep(7000);
            } catch (Exception ex1) {
                return false;
            }
            return false;
        } catch (InterruptedException ex) {
            //ex.printStackTrace();
            return false;
        }
    }

    public void send(String s) throws IOException {
        if (s != null) {
            out.println(s);
            out.flush();
        }

        if ((line = in.readLine()) != null) // output the response
            System.out.println(line);
    }
}
