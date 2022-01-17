package yelp.service;

import yelp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import yelp.domain.User;

@Transactional(readOnly = true)
@Service
public class DefaultUserService implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public DefaultUserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional(readOnly = false)
	public User registerNewUser(User user) {
		
		//Empty id before creating a new user to avoid overwriting a user
		user.setId(null);
		
		//Set password, we need to encrypt it, we will use BCrypt for the purpose
		//In the file YelpApplication you can find the method (and bean) to do it
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		//In this case we can get an optional (from repository), as we can get an optional
		// we need to define what we will return in case the user returned using the id
		// parse is null
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Could not find User with ID [" + id + "]"));
	}

	@Override
	public void anonymize(User user) {
		user.setEmail(user.getId()+"@anonymous.com");
		user.setFirstName("Anonymous");
		user.setLastName("");
		userRepository.save(user);		
	}


}
