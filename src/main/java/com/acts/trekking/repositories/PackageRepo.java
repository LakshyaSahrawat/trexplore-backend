package com.acts.trekking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acts.trekking.entities.Package;

public interface PackageRepo extends JpaRepository<Package, Long> {

}
