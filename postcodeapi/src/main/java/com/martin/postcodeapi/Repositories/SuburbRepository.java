package com.martin.postcodeapi.Repositories;

import com.martin.postcodeapi.model.Suburb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuburbRepository extends JpaRepository<Suburb, Long> {}
