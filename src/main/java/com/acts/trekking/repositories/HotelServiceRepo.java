package com.acts.trekking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acts.trekking.entities.User;

public interface HotelServiceRepo extends JpaRepository<User, Integer> {

}
