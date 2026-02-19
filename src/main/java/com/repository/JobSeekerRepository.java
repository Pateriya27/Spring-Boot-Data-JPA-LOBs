package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

}
