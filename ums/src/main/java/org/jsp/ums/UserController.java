package org.jsp.ums;

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

    @PostMapping
    public User saveuser(@RequestBody User u)
    {
    	return repo.save(u);
    }
    @GetMapping
    public List<User> allusers()
    {
    	List<User> ap = repo.findAll();
        return ap;
    }
    @GetMapping("/{id}")
    public User finduserbyid(@PathVariable int id)
    {
    	Optional<User> op = repo.findById(id);
    	
    	if(op.isPresent())
    	{
    		return op.get();
    	}
    	return null;
    }
    @DeleteMapping("/{id}")
    public String deleteuserbyid(@PathVariable int id)
    {
    	Optional<User> op = repo.findById(id);
    	
    	if(op.isPresent())
    	{
    		repo.deleteById(id);
    	    return "User deleted successfully";
    	}
    	return "User not deleted";
    }
    
    @PutMapping
    public User updateUser(@RequestBody User u)
    {
    	return repo.save(u);
    }
    
    @PatchMapping("/email/{id}/{email}")
    public User updateEmail(@PathVariable int id,@PathVariable String email)
    {
    	Optional<User> optional = repo.findById(id);
    	if(optional.isPresent())
    	{
    		User u = optional.get();
    		u.setEmail(email);
    		return repo.save(u);
    	}
    	else
    	{
    		return null;
    	}
    } 
    @PatchMapping("/name/{id}/{name}")
    public User updateName(@PathVariable int id,@PathVariable String name)
    {
    	Optional<User> optional = repo.findById(id);
    	if(optional.isPresent())
    	{
    		User u = optional.get();
    		u.setName(name);
    		return repo.save(u);
    	}
    	else
    	{
    		return null;
    	}
    } 
    
    
    @PatchMapping("/phone/{id}/{phone}")
    public User updatePhone(@PathVariable int id,@PathVariable long phone)
    {
    	Optional<User> optional = repo.findById(id);
    	if(optional.isPresent())
    	{
    		User u = optional.get();
    		u.setPhone(phone);
    		return repo.save(u);
    	}
    	return null;
    }
    
    @PatchMapping("/password/{phone}/{email}/{password}")
    public User updatePhone(@PathVariable long phone,@PathVariable String email,@PathVariable String password)
    {
    	User u = repo.findByPhoneAndEmail(phone,email);
    	if(u!=null)
    		return repo.save(u);
    	else
    		return null;
    }
    
    
    @GetMapping("/login/{email}/{password}")
    public User Login(@PathVariable String email,@PathVariable String password) {
        return repo.findByEmailAndPassword(email,password);
    }
    
  }

//    	List<User> u1 = repo.findAll();
//    	for(User u : u1)
//    	{
//    		if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equalsIgnoreCase(password))
//    		{
//    			return u;
//    		}
//    	}



//    	List<User> all = repo.findAll();
//    	for(User u:all)
//    	{
//    		if(u.getPhone() == phone && u.getEmail().equalsIgnoreCase(email))
//    		{
//    			u.setPassword(password);
//    			repo.save(u);
//    		}
//    	}
//    	return null;