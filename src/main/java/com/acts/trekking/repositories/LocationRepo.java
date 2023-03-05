package com.acts.trekking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acts.trekking.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

}
