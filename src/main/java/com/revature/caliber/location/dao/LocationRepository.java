package com.revature.caliber.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.location.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
