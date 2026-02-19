package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.JobSeeker;
import com.repository.JobSeekerRepository;
@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	
	@Autowired
	private JobSeekerRepository repo;

	@Override
	public String registerJobSeeker(JobSeeker js) {
		Integer id = repo.save(js).getJsid();
		return "Job Seeker Details are Saved with id :: "+id;
	}

	@Override
	public JobSeeker findJobSeekerById(int jsid) {
		return repo.findById(jsid).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
	}

}
