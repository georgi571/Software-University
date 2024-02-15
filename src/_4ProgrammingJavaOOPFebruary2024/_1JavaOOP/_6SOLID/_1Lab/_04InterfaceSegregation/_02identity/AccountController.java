package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._04InterfaceSegregation._02identity;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._04InterfaceSegregation._02identity.interfaces.Account;

public class AccountController {
    private final Account manager;

    public AccountController(Account manager) {
        this.manager = manager;
    }
    public void changePassword(String oldPass,String newPass){
        this.manager.changePassword(oldPass,newPass);
    }
}
