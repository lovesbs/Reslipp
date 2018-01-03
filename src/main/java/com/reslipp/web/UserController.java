package com.reslipp.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reslipp.domain.User;
import com.reslipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	private List<User> users=new ArrayList<User>();
	
	@Autowired
	private UserRepository ur;
	
	@GetMapping("/loginform")
	public String loginform(){
		return "/user/login";
	}
	
	@PostMapping("login")
	public String login(String userid,String password,HttpSession httpSession){
		User user=ur.findByUserid(userid);
		if(user==null){
			return "redirect:/users/loginform";
		}
		if(!password.equals(user.getPassword())){
			return "redirect:/users/loginform";
			
		}
		httpSession.setAttribute("user", user);
		return "redirect:/";
	}
	
	@GetMapping("/form")
	public String form(){
		return "/user/form";
	}
	
	@PostMapping("")
	public String create(User user){
		System.out.println(user);;
		//users.add(user);
		ur.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String list(Model model){
		model.addAttribute("users",ur.findAll());
		return "/user/list";
	}
	
	@GetMapping("/{id}/form")
	public String userform(@PathVariable Long id,Model model){
		model.addAttribute("user", ur.findOne(id));
		return "/user/updateform";
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable Long id,User newUser){
		User user=ur.findOne(id);
		user.update(newUser);
		ur.save(user);
		return "redirect:/users";
	}
}