package com.service;

import com.entity.JobSeeker;

public interface IJobSeekerMgmtService {

	public String registerJobSeeker(JobSeeker js);
	public JobSeeker findJobSeekerById(int jsid);
	
}
