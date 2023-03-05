package app.controller;

import app.dao.UserDao;
import app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    //Creating User with Get method.
    @RequestMapping(value = "/user/create",method = RequestMethod.GET)
    public String userCreatGet(){
        return "user.create";
    }

    //Creating User with Post method.
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String userCreatPost(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("city")String city){
        UserDao userDao=new UserDao();
        User user=new User(name,email,phone,city);
        userDao.createUser(user);
        return "user.view"; }
    //Deleting User.
    @RequestMapping(value = "/user/delete", method=RequestMethod.POST)
    public String deleteUser(@RequestParam("id")String stringid){
        UserDao userDao=new UserDao();
        int id=Integer.valueOf(stringid);
        int status=userDao.deleteUser(id);
        if (status==0){
            System.out.println("An error happen when deleting user");
        }
        return "user.view";
    }
    //Get data from Database to edit with id
    @RequestMapping(value = "/user/edit",method = RequestMethod.GET)
    public String getUserById(@RequestParam("id") String Editid){
        int id=Integer.valueOf(Editid);
        UserDao userDao=new UserDao();
        userDao.getUserById(id);
        return "user.edit";
    }
    //Editing user.
    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    public String editUser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("city")String city,@RequestParam("id")String stringid){
        int id=Integer.valueOf(stringid);
        User user=new User(id,name,email,phone,city);
        UserDao userDao=new UserDao();
        userDao.EditUser(user);
        return "user.view";
    }
}
