package com.martin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "postcodes")
public class Postcode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String code;

  public Postcode(Long id, String code, Suburb suburb) {
    this.id = id;
    this.code = code;
    this.suburb = suburb;
  }

  @ManyToOne
  @JoinColumn(name = "suburb_id")
  private Suburb suburb;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Suburb getSuburb() {
    return suburb;
  }

  public void setSuburb(Suburb suburb) {
    this.suburb = suburb;
  }
}
