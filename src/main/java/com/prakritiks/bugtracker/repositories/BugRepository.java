package com.prakritiks.bugtracker.repositories;

import java.util.Optional;

import com.prakritiks.bugtracker.models.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BugRepository extends JpaRepository<Bug,Integer> {

    Optional<Bug> findById(Integer bugId);

}
