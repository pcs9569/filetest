package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Member;
import fishbun.fishbunspring.domain.User;
import fishbun.fishbunspring.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        userRepository.insert(user);
        System.out.println("--------------------" + "service" + "-------------------------------");
        System.out.println(user.getU_email());
        System.out.println(user.getU_name());
        System.out.println(user.getU_pw());

        return user;
    }

    public User modify(User user){
        userRepository.updateUser(user);

        System.out.println("--------------------" + "service" + "-------------------------------");
        System.out.println(user.getU_email());
        System.out.println(user.getU_name());
        System.out.println(user.getU_pw());
        System.out.println(user.getU_level());

        return user;
    }

    public void remove(User user){
        userRepository.deleteUser(user);
    }

    public List<User> findAll() {
        return userRepository.selectAll();
    }
    public User findByEmail(String u_email) {
        return userRepository.selectByEmail(u_email);
    }
}
