package de.friendsurance.ca.dto;

import de.friendsurance.ca.model.Category;

public class ContractDto {

  private Long id;
  private String number;
  private Category category;
  private String company;
  private double yearlyPremium;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public double getYearlyPremium() {
    return yearlyPremium;
  }

  public void setYearlyPremium(double yearlyPremium) {
    this.yearlyPremium = yearlyPremium;
  }

}
