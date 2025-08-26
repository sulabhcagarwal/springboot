package de.friendsurance.ca.controller;

import de.friendsurance.ca.dto.ContractDto;
import de.friendsurance.ca.dto.UserDto;
import de.friendsurance.ca.exception.UserNotFoundException;
import de.friendsurance.ca.model.Contract;
import de.friendsurance.ca.model.User;
import de.friendsurance.ca.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers() {
    List<User> users = userService.getUsers();
    List<UserDto> userDtos = new ArrayList<>();
    for (User user : users) {
      userDtos.add(convertUser(user));
    }
    return ResponseEntity.ok(userDtos);
  }

  @GetMapping("/{userid}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long userid){
      try{
          var user = userService.getUserById(userid);
          return ResponseEntity.ok(convertUser(user));
      }catch(UserNotFoundException exp){
          return ResponseEntity.notFound().build();
      }
  }

  public UserDto convertUser(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setName(user.getName());
    if(user.getContracts()!= null && !user.getContracts().isEmpty()) {
        List<ContractDto> contracts = user.getContracts().stream().map(this::convertContract).toList();
        dto.setContracts(contracts);
    }
    return dto;
  }

  private ContractDto convertContract(Contract contract) {
    ContractDto dto = new ContractDto();
    dto.setId(contract.getId());
    dto.setNumber(contract.getNumber());
    dto.setCategory(contract.getCategory());
    dto.setCompany(contract.getCompany());
    dto.setYearlyPremium(contract.getYearlyPremium());
    return dto;
  }

}
