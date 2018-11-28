package com.serjes.equiper;

import com.serjes.equiper.domain.User;
import com.serjes.equiper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class EquiperApplication {

//    @Autowired
//    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(EquiperApplication.class, args);
    }

//    @PostConstruct
//    public void init(){
//        User user = new User();
//        user.setName("user");
//        user.setPassword(new BCryptPasswordEncoder().encode("123"));
//        user.setRole("USER");
//        userRepository.save(user);
//    }
}
