# AutomatedEmailJava
Send automated e-mails in Java without using the JavaMail API.

#Umm... why didn't you just use the JavaMail API?
Well, I needed my project to be completely client side (no servers, nothing), if I had used the JavaMail API the user would've had to install a bunch of stuff before being able to receive automated emails from my program. 

#Getting started (SendEmail.java)
  ![alt tag](https://raw.githubusercontent.com/Ahan2/AutomatedEmailJava/master/assets/server.png)
        
    Change the "your.smtp.server" to your smtp server.
-------------------
  ![alt tag](https://raw.githubusercontent.com/Ahan2/AutomatedEmailJava/master/assets/login.png)
    
    Enter your login ID/Username in the first send("")
    Enter your password in the second send("")
-------------------
  ![alt tag](https://raw.githubusercontent.com/Ahan2/AutomatedEmailJava/master/assets/email.png)
    
    Enter your email
    Enter the second recipients email (this is optional, you can remove it if you only have one recipient)
-------------------
  ![alt tag](https://raw.githubusercontent.com/Ahan2/AutomatedEmailJava/master/assets/format.png)
    
    Enter your name, email, subject & content *exactly in this format*
------------------- 
#Main.java
![alt tag](https://raw.githubusercontent.com/Ahan2/AutomatedEmailJava/master/assets/main.png)
    
    This is pretty self-explanatory 😛
    
#Email format reference(s):
https://www.cs.cf.ac.uk/Dave/PERL/node175.html
