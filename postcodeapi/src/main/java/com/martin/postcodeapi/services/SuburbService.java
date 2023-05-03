package com.martin.postcodeapi.services;

import com.martin.postcodeapi.DAOs.SuburbDao;
import com.martin.postcodeapi.model.Postcode;
import com.martin.postcodeapi.model.Suburb;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuburbService {

  @Autowired
  private SuburbDao suburbDao;

  public Suburb getSuburbByPostcode(String postcode) {
    Optional<Suburb> suburbOptional = suburbDao.findByPostcodesCode(postcode);
    return suburbOptional.orElseThrow(() ->
      new EntityNotFoundException("suburb not found for postcode: " + postcode)
    );
  }

  public Postcode getPostCodeBySuburbName(String suburbName) {
    Optional<Postcode> postCodeOptional = suburbDao.findBySuburbName(
      suburbName
    );
    return postCodeOptional.orElseThrow(() ->
      new EntityNotFoundException(
        "postcode not found for suburb: " + suburbName
      )
    );
  }

  public void addSuburbAndPostCode(Suburb suburb) {
    suburbDao.save(suburb);
  }
}
