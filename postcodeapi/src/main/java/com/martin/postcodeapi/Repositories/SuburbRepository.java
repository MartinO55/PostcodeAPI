package com.martin.postcodeapi.Repositories;

import com.martin.postcodeapi.model.Suburb;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuburbRepository extends JpaRepository<Suburb, Long> {
  Optional<Suburb> findbyName(String name);
}
