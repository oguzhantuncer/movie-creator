package com.tuncer.moviecreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuncer.moviecreator.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	List<Actor> findByName(String name);
}
