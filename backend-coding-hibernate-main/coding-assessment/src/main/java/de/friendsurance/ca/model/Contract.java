package de.friendsurance.ca.model;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contracts")
public class Contract {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private String number;

  @Enumerated(STRING)
  private Category category;

  private String company;

  private double yearlyPremium;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public Long getId() {
    return id;
  }

  public String getNumber() {
    return number;
  }

  public Category getCategory() {
    return category;
  }

  public String getCompany() {
    return company;
  }

  public double getYearlyPremium() {
    return yearlyPremium;
  }

}
