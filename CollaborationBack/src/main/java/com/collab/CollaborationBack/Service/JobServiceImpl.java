package com.collab.CollaborationBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collab.CollaborationBack.Dao.JobDao;
import com.collab.CollaborationBack.model.Job;
@Service(value="jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	JobDao jobDao;
	public boolean addjob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.addjob(job);
	}
	public boolean updatejob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.updatejob(job);
	}
	public boolean deletejob(int jobId) {
		// TODO Auto-generated method stub
		return jobDao.deletejob(jobId);
	}
	public List<Job> getalljob() {
		// TODO Auto-generated method stub
		return jobDao.getalljob();
	}
	public Job getjobById(int jobId) {
		// TODO Auto-generated method stub
		return jobDao.getjobById(jobId);
	}

}
