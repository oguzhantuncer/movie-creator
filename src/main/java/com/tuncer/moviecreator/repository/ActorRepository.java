package com.tuncer.moviecreator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuncer.moviecreator.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
