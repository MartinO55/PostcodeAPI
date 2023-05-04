package com.martin.postcodeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "suburbs")
public class Suburb {

  public Suburb(Long id, String suburbName, String postCode) {
    this.id = id;
    this.suburbName = suburbName;
    this.postCode = postCode;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  @NotBlank
  String suburbName;

  @Column
  String postCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getSuburbName() {
    return suburbName;
  }

  public void setSuburbName(String suburbName) {
    this.suburbName = suburbName;
  }
}
