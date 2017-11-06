package com.collab.CollaborationBack.Service;

import java.util.List;

import com.collab.CollaborationBack.model.Job;

public interface JobService {

	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(int jobId);
	List<Job> getalljob();
	Job getjobById(int jobId);
}
