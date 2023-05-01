package com.martin.model;

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
  private String name;

  public Suburb(Long id, String name, List<Postcode> postcodes) {
    this.id = id;
    this.name = name;
    this.postcodes = postcodes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
