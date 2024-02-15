package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._04InterfaceSegregation._02identity.interfaces;

public interface Account {

    void register(String username, String password);

    void login(String username, String password);

    void changePassword(String oldPass, String newPass);


}
