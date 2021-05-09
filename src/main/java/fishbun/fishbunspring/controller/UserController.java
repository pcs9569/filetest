package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.User;
import fishbun.fishbunspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired //생성자를 통한 DI
    public UserController(UserService userService){
        this.userService = userService;
    }

//    @GetMapping("/new")
//    public String createForm(){
//        return "users/createUserForm";
//    }

    //@PostMapping은 보통 데이터를 폼같은 것에 넣어서 보낼 때, @GetMapping은 조회할 때 주로 쓰임
    //URL은 같지만 GET이냐 POST에 따라서 다르게 Mapping할 수 있다

    //domain의 User를 써도 되나????
/*    @PostMapping("/user/new")
    public String create(UserForm form){
        User user = new User();
        user.setU_email(form.getEmail());
        user.setU_pw(form.getPw());
        user.setU_name(form.getName());
        user.setU_level(form.getLevel());


        userService.join(user);

        return "redirect:users/";
    }*/


    @PostMapping("")
    @ResponseBody
    public User create(String u_email, String u_pw, String u_name) {
        System.out.println("-----------------" + "controller" + "----------------------");
        System.out.println(u_email);
        System.out.println(u_pw);
        System.out.println(u_name);

        User user = new User();

        user.setU_email(u_email);
        user.setU_pw(u_pw);
        user.setU_name(u_name);

        userService.save(user);

        return user;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> lists(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("users",user);
        return user;
    }

    //    @GetMapping("/user")
//    @ResponseBody
//    public Optional<User> findUser(@RequestParam(required = false, value = "u_email") String u_email){
//
//        return userService.findOne(u_email);
//    }
    @GetMapping("/{u_email}")
    @ResponseBody
    public User listUser(@PathVariable String u_email){

        return userService.findByEmail(u_email);
    }

    @PutMapping("/{u_email}")
    @ResponseBody
    public User changeUser(@PathVariable @RequestParam(required = true, value = "u_email") String u_email,
                           @RequestParam(required = false, value = "u_pw") String u_pw,
                           @RequestParam(required = false, value = "u_name") String u_name,
                           @RequestParam(required = false, value = "u_level") Integer u_level
    ){
        System.out.println("-----------------" + "controller" + "----------------------");
        System.out.println(u_email);
        System.out.println(u_pw);
        System.out.println(u_name);
        System.out.println(u_level);


//        Optional<User> user1 = userService.findOne(u_email);
        User user = userService.findByEmail(u_email);

        user.setU_email(u_email);

        if(u_pw != null) {
            user.setU_pw(u_pw);
        }

        if(u_name != null) {
            user.setU_name(u_name);
        }

        if(u_level != null) {
            user.setU_level(u_level);
        }

        return userService.modify(user);

    }

    @DeleteMapping("/{u_email}")
    @ResponseBody
    public void destroyUser(@PathVariable String u_email){
        User user = userService.findByEmail(u_email);

        userService.remove(user);

    }




}
