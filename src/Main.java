import core.User;
import core.exceptions.AccessDeniedException;
import core.exceptions.UserNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));

        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        return new User[]{
                new User("John", "pass", "jhon@gmail.com", 24),
                new User("Mike", "pass2", "miken@gmail.com", 4),
                new User("Sinthiya", "pass3", "sinth@gmail.com", 44),
                new User("Jacob", "pass4", "jacob@gmail.com", 41)
        };
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < 18) {
            throw new AccessDeniedException("Ты слишком молод, друг ¯\\_(ツ)_/¯");
        }
    }

}
