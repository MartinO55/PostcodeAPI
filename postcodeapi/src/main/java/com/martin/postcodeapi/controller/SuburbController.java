package com.martin.postcodeapi.controller;

import com.martin.postcodeapi.model.Postcode;
import com.martin.postcodeapi.model.Suburb;
import com.martin.postcodeapi.services.SuburbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {

  @Autowired
  private SuburbService suburbService;

  @GetMapping("/postcode/{postcode}")
  public ResponseEntity<Suburb> getSuburbByPostcode(
    @PathVariable String postcode
  ) {
    Suburb suburb = suburbService.getSuburbByPostcode(postcode);
    return ResponseEntity.ok(suburb);
  }

  @GetMapping("/name/{suburbName}/postcode")
  public ResponseEntity<Postcode> getPostCodeBySuburbName(
    @PathVariable String suburbName
  ) {
    Postcode postcode = suburbService.getPostCodeBySuburbName(suburbName);
    return ResponseEntity.ok(postcode);
  }

  @PostMapping("/")
  public ResponseEntity<Suburb> addSuburbAndPostCode(
    @RequestBody Suburb suburb
  ) {
    suburbService.addSuburbAndPostCode(suburb);
    return ResponseEntity.ok().build();
  }
}
