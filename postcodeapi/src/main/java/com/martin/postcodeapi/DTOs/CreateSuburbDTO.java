package com.martin.postcodeapi.DTOs;

import jakarta.validation.constraints.NotBlank;

public class CreateSuburbDTO {

  @NotBlank
  String suburbName;

  String postCode;

  public CreateSuburbDTO(String suburbName, String postCode) {
    this.suburbName = suburbName;
    this.postCode = postCode;
  }

  public String getSuburbName() {
    return suburbName;
  }

  public void setSuburbName(String suburbName) {
    this.suburbName = suburbName;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
}
