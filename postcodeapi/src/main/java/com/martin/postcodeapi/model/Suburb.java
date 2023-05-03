package com.martin.postcodeapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "suburbs")
public class Suburb {

  // I don't know why, but these variables are neccessary to start the server. I know they are unused, but the code breaks without them.
  private int code;
  private String suburb;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(nullable = false, name = "name")
  private String suburbName;

  public Suburb(Long id, String suburbName, List<Postcode> postcodes) {
    this.id = id;
    this.suburbName = suburbName;
    this.postcodes = postcodes;
  }

  public String getName() {
    return suburbName;
  }

  public void setName(String suburbName) {
    this.suburbName = suburbName;
  }

  @OneToMany(
    mappedBy = "suburb",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY
  )
  private List<Postcode> postcodes;

  public List<Postcode> getPostcodes() {
    return postcodes;
  }

  public void setPostcodes(List<Postcode> postcodes) {
    this.postcodes = postcodes;
  }
}
