package com.martin.postcodeapi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "postcodes")
public class Postcode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String postcode;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "suburb_postcodes",
    joinColumns = @JoinColumn(name = "suburb_id"),
    inverseJoinColumns = @JoinColumn(name = "postcode_id")
  )
  private Set<Suburb> suburbs = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
}
