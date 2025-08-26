package de.friendsurance.ca.service;

import de.friendsurance.ca.model.User;
import de.friendsurance.ca.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  private UserService userService;

  @BeforeEach
  void setUp() {
    userService = new UserService(userRepository);
  }

  @Test
  void getUsers_ShouldReturnAllUsers() {
    List<User> expectedUsers = List.of(new User(), new User());
    when(userRepository.findAll()).thenReturn(expectedUsers);

    List<User> actualUsers = userService.getUsers();

    assertThat(actualUsers).isEqualTo(expectedUsers);
    verify(userRepository).findAll();
  }

}