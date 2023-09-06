package views;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi there, Welcome to the app!");
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Sign Up");
        System.out.println("Press 0 to Exit");

        int choice = 0;

        choice = sc.nextInt();

        switch(choice){
            case 1 -> login();
            case 2 -> signup();
            case 0 -> System.exit(0);
        }
    }
    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        try {
            if(UserDAO.isExits(email)){
                String genOTP = GenerateOTP.getOTP();
                SendOTPService.sendOTP(email, genOTP);
                System.out.println("Enter the OTP");
                String otp = sc.nextLine();
                if(otp.equals(genOTP)){
                    new UserView(email).home();

                }else{
                    System.out.println("Invalid OTP");
                }
            }else{
                System.out.println("User not found");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    private void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        String genOTP = GenerateOTP.getOTP();
        SendOTPService.sendOTP(email, genOTP);
        System.out.println("Enter the OTP");
        String otp = sc.nextLine();
        if(otp.equals(genOTP)){
            User user = new User(name, email);
            int response = UserService.saveUser(user);
            switch(response){
                case 0 -> System.out.println("User Registered");
                case 1 -> System.out.println("User Already Exists");
            }
        }else{
            System.out.println("Invalid OTP");
        }


    }


}
