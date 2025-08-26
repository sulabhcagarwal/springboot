package de.friendsurance.ca.service;

import de.friendsurance.ca.exception.UserNotFoundException;
import de.friendsurance.ca.model.User;
import de.friendsurance.ca.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    var users = userRepository.findAll();
    users.forEach(user -> Hibernate.initialize(user.getContracts()));
    return users;
  }

    public User getUserById(Long id) throws UserNotFoundException {
      var user = userRepository.findById(id);
      if(user.isPresent()){
          Hibernate.initialize(user.get().getContracts());
          return user.get();
      } else{
          throw new UserNotFoundException(String.format("User with id: %s not found",id));
      }
    }
}

