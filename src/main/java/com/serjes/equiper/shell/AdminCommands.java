package com.serjes.equiper.shell;


import com.serjes.equiper.domain.User;
import com.serjes.equiper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AdminCommands {

    private final UserRepository userRepository;

    public AdminCommands(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ShellMethod("Добавить пользователя: adduser name pas role" +
            "\n    4 вида ролей: admin, manager, engineer, finresp")
    public void adduser(
            @ShellOption String name,
            @ShellOption String password,
            @ShellOption String role
    ) {

        String userRole = null;
        switch (role) {
            case "admin":
                userRole = User.ROLE_ADMIN;
                break;
            case "manager":
                userRole = User.ROLE_MANAGER;
                break;
            case "engineer":
                userRole = User.ROLE_ENGINEER;
                break;
            case "finresp":
                userRole = User.ROLE_FIN_RESP;
                break;
            default:
                userRole = User.ROLE_VIEWER;
                break;
        }

        User user = new User(name, new BCryptPasswordEncoder().encode(password), userRole);
        userRepository.save(user);
    }
}
