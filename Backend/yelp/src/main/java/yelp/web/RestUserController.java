package yelp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import yelp.domain.JsonViews;
import yelp.domain.User;
import yelp.service.UserService;

@RestController
@RequestMapping("/users")
public class RestUserController {

	UserService userService;
	
	@Autowired
	public RestUserController (UserService userService){
		this.userService = userService;
	}
		
	//CHECK!!!!!! This class can be working different, in the example we had
	// from Sam it was working different, but it should work!
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/sign_up")
	public User registerNewUser(@RequestBody User postedUser) {
		return userService.registerNewUser(postedUser);
	}
	
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/sign_in")
	public User login(@RequestBody User postedUser) {
		return userService.registerNewUser(postedUser);
	}
	
	@JsonView(JsonViews.Public.class)
	@PutMapping
	public User editUser (@RequestBody User postedUser) {
		return userService.update(postedUser);
	}
	
	
	
}
