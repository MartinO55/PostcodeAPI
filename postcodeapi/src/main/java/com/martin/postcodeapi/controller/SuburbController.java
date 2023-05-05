package com.martin.postcodeapi.controller;

import com.martin.postcodeapi.DTOs.CreateSuburbDTO;
import com.martin.postcodeapi.model.Suburb;
import com.martin.postcodeapi.services.SuburbService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  @PostMapping
  public ResponseEntity<Suburb> createSuburb(
    @Valid @RequestBody CreateSuburbDTO data
  ) {
    Suburb createdSuburb = this.suburbService.create(data);
    return new ResponseEntity<>(createdSuburb, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Suburb>> getSuburbs() {
    List<Suburb> allSuburbs = this.suburbService.getSuburbs();

    return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Suburb> getSuburbbyID(@PathVariable Long id) {
    Optional<Suburb> maybeSuburb = this.suburbService.findByID(id);

    if (maybeSuburb.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(maybeSuburb.get(), HttpStatus.OK);
  }
}
