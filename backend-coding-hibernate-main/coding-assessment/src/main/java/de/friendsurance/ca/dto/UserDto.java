package de.friendsurance.ca.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

  private Long id;
  private String name;
  private List<ContractDto> contracts = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ContractDto> getContracts() {
    return contracts;
  }

  public void setContracts(List<ContractDto> contracts) {
    this.contracts = contracts;
  }

}



