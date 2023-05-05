package com.martin.postcodeapi.services;

import com.martin.postcodeapi.DTOs.CreateSuburbDTO;
import com.martin.postcodeapi.Repositories.SuburbRepository;
import com.martin.postcodeapi.model.Suburb;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
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

  public Optional<Suburb> findByName(String suburbName) {
    return this.suburbRepository.findbyName(suburbName);
  }

  public Optional<Suburb> findByPostCode(String postCode) {
    return this.suburbRepository.findbyName(postCode);
  }
}
