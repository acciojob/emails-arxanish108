package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one dig
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(newPassword)){
            if(isValid(newPassword)){
                System.out.println("Password Changed Success");
                this.password = newPassword;
            }
            else{
                System.out.println("Password is not valid");
            }
        }
        else{
            System.out.println("Given Password Not Match with current one");
        }

    }

    private Boolean isValid(String password){
        Boolean cap = false;
        Boolean sma = false;
        Boolean dig = false;
        Boolean spe = false;

        if(password.length()<8) return false;

        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if(ch>= 'a' && ch<= 'z')
                sma = true;
            else if(ch>= 'A' && ch<= 'Z')
                cap = true;
            else if(ch>= '0' && ch<= '0')
                dig = true;
            else spe = true;
        }

        if(cap == true && sma == true && dig == true && spe == true)
            return true;
        return false;
    }
}
