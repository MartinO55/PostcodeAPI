package com.martin.postcodeapi.DTOs;

import com.martin.postcodeapi.model.Postcode;
import com.martin.postcodeapi.model.Suburb;

public class SuburbDTO {

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private Postcode postcode;

  public Postcode getPostCode() {
    return postcode;
  }

  public void setPostcode(Postcode postcode) {
    this.postcode = postcode;
  }

  public static SuburbDTO fromSuburb(Suburb suburb) {
    SuburbDTO suburbDto = new SuburbDTO();
    suburbDto.setId(suburb.getId());
    suburbDto.setName(suburb.getName());
    suburbDto.setPostcode(suburb.getPostcodes().get(0));
    return suburbDto;
  }
}
