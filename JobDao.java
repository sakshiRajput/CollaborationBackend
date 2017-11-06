package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Job;

public interface JobDao {

	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(int jobId);
	List<Job> getalljob();
	Job getjobById(int jobId);

}
