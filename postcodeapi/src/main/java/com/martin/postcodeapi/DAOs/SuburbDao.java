package com.martin.postcodeapi.DAOs;

import com.martin.postcodeapi.model.Postcode;
import com.martin.postcodeapi.model.Suburb;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbDao extends JpaRepository<Suburb, Long> {
  Optional<Suburb> findByPostcodesCode(String postcode);

  Optional<Postcode> findBySuburbName(String suburbName);
}
