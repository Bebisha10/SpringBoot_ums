package org.jsp.ums;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseStructure<User> finduserbyid(int id) {
		Optional<User> optional = dao.finduserbyid(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (optional.isPresent()) {
			User u = optional.get();
			structure.setStatus(200);
			structure.setMessage("User Found Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invalid User id, User not Found");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> deleteuserbyid(int id) {
		String s = dao.deleteuserbyid(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (s != null) {
			structure.setStatus(200);
			structure.setMessage(s);
			structure.setBody(null);
		} else {
			structure.setStatus(404);
			structure.setMessage(s);
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<List<User>> allusers() {
		List<User> users = dao.allusers();
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		if (users != null && !users.isEmpty()) {
			structure.setStatus(200);
			structure.setMessage("List of users");
			structure.setBody(users);
		} else {
			structure.setStatus(404);
			structure.setMessage("No Users found");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> saveuser(User u) {
		User user = dao.saveuser(u);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setStatus(200);
			structure.setMessage("User Saved Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("User not saved");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> updateuser(User u) {
		User user = dao.updateuser(u);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setStatus(200);
			structure.setMessage("User updated Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("User not saved");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> updateEmail(int id, String email) {
		User u = dao.updateEmail(id, email);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (u != null) {
			structure.setStatus(200);
			structure.setMessage("User updated Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invaid user id,User not updated");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> updateName(int id, String name) {
		User u = dao.updateName(id, name);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (u != null) {
			structure.setStatus(200);
			structure.setMessage("User updated Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invaid user id,User not updated");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<User> updatePhone(int id, long phone) {
		User u = dao.updatePhone(id, phone);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (u != null) {
			structure.setStatus(200);
			structure.setMessage("User updated Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invaid user id,User not updated");
			structure.setBody(null);
		}
		return structure;
	}
	public ResponseStructure<User> updatePassword(long phone, String email, String password) {
		User u = dao.updatePassword(phone,email,password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (u != null) {
			structure.setStatus(200);
			structure.setMessage("User updated Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invaid user id,User not updated");
			structure.setBody(null);
		}
		return structure;
	}
	public ResponseStructure<User> login(String email, String password) {
		User u = dao.login(email,password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (u != null) {
			structure.setStatus(200);
			structure.setMessage("Login done Successfully");
			structure.setBody(u);
		} else {
			structure.setStatus(404);
			structure.setMessage("Invaid credentials,Unable to login");
			structure.setBody(null);
		}
		return structure;
	}

}
