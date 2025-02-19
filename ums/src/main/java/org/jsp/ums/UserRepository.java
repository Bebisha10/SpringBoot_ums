package org.jsp.ums;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmailAndPassword(String email, String password);

	User findByPhoneAndEmail(long phone, String email);
	
}
