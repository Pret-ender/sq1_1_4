package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> testList = new ArrayList<>();
        testList.add(new User("Лена", "Сергеева", (byte) 20));
        testList.add(new User("кори", "тейлор", (byte) 30));
        testList.add(new User("чайник", "подносов", (byte) 44));
        testList.add(new User("дорога", "дальняя", (byte) 56));
        testList.forEach(x -> {
            userService.saveUser(x.getName(), x.getLastName(), x.getAge());
            System.out.format("User с именем – %s добавлен в базу данных%n", x.getName());
        });
        userService.getAllUsers().forEach(user -> System.out.println(user.toString())); ;
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
