package com.martin.postcodeapi.services;

import com.martin.postcodeapi.DTOs.CreateSuburbDTO;
import com.martin.postcodeapi.Repositories.SuburbRepository;
import com.martin.postcodeapi.model.Suburb;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class SuburbService {

  @Autowired
  private SuburbRepository suburbRepository;

  public Suburb create(@Valid CreateSuburbDTO data) {
    String suburbName = data.getSuburbName().trim();
    String postCode = data.getPostCode().trim();

    Suburb newSuburb = new Suburb();

    newSuburb.setPostCode(postCode);
    newSuburb.setSuburbName(suburbName);

    return this.suburbRepository.save(newSuburb);
  }

  public List<Suburb> getSuburbs() {
    return this.suburbRepository.findAll();
  }

  public Optional<Suburb> findByID(Long id) {
    return this.suburbRepository.findById(id);
  }
}
