package org.jsp.ums;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private UserRepository repo;

	public Optional<User> finduserbyid(int id) {
		return repo.findById(id);
	}

	public String deleteuserbyid(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "User Deleted Successfully";
		}
		return "Invalid id,User not deleted";
	}

	public List<User> allusers() {
		List<User> ul = repo.findAll();
		return ul;
	}

	public User saveuser(User u) {
		return repo.save(u);
	}

	public User updateuser(User u) {
		return repo.save(u);
	}

	public User updateEmail(int id, String email) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User u = optional.get();
			u.setEmail(email);
			return repo.save(u);
		} else {
			return null;
		}

	}

	public User updateName(int id, String name) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User u = optional.get();
			u.setName(name);
			return repo.save(u);
		} else {
			return null;
		}
	}

	public User updatePhone(int id, long phone) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User u = optional.get();
			u.setPhone(phone);
			return repo.save(u);
		} else {
			return null;
		}
	}

	public User updatePassword(long phone, String email, String password) {
		User u = repo.findByPhoneAndEmail(phone, email);
		if (u != null) {
			u.setPassword(password);
			return repo.save(u);
		}
		return null;
	}

	public User login(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}
}
