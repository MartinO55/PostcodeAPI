package com.martin.postcodeapi.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suburbs")
public class Suburb implements Serializable {

  // I don't know why, but these variables are neccessary to start the server. I know they are unused, but the code breaks without them.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String suburbName;

  @ManyToMany(mappedBy = "postcodes")
  private Set<Postcode> postcodes = new HashSet<>();

  public Suburb(Long id, String suburbName) {
    this.id = id;
    this.suburbName = suburbName;
  }

  public String getName() {
    return suburbName;
  }

  public void setName(String suburbName) {
    this.suburbName = suburbName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
