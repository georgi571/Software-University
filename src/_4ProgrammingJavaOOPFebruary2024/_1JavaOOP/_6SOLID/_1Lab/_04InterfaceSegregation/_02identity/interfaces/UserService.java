package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._04InterfaceSegregation._02identity.interfaces;

public interface UserService {
    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    User getUserByName(String name);
}
