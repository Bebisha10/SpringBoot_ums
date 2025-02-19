package org.jsp.ums;

//both take user input to API(PV & RP)

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController 
{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public UserService service;

    @PostMapping 
    public ResponseStructure<User> saveuser(@RequestBody User u){
    	return service.saveuser(u);
    }
    @GetMapping
    public ResponseStructure<List<User>> allusers(){
        return service.allusers();
    }
    
    @GetMapping("/{id}")
    public ResponseStructure<User> finduserbyid(@PathVariable int id) {
    	return service.finduserbyid(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseStructure<User> deleteuserbyid(@PathVariable int id){
    	return service.deleteuserbyid(id);
    }
    
    @PutMapping
    public ResponseStructure<User> updateUser(@RequestBody User u){
    	return service.updateuser(u);
    }
    
    @PatchMapping("/email/{id}/{email}")
    public ResponseStructure<User> updateEmail(@PathVariable int id,@PathVariable String email){
    	return service.updateEmail(id,email);
    } 
    
    @PatchMapping("/name/{id}/{name}")
    public ResponseStructure<User> updateName(@PathVariable int id,@PathVariable String name){
    	return service.updateName(id,name);
    } 
    
    
    @PatchMapping("/phone/{id}/{phone}")
    public ResponseStructure<User> updatePhone(@PathVariable int id,@PathVariable long phone){
    	return service.updatePhone(id, phone);
    }
    
    @PatchMapping("/password/{phone}/{email}/{password}")
    public ResponseStructure<User> updatePassword(@PathVariable long phone,@PathVariable String email,@PathVariable String password){
    	return service.updatePassword(phone, email, password);
    }
    
    @GetMapping("/login/{email}/{password}")
    public ResponseStructure<User> login(@PathVariable String email,@PathVariable String password) {
        return service.login(email, password);
    }
    
  }