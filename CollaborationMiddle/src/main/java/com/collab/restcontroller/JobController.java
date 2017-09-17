package com.collab.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.CollaborationBack.Dao.JobDao;
import com.collab.CollaborationBack.model.Job;

@RestController
public class JobController {
	
	@Autowired
	JobDao jobDao;

	@GetMapping(value="/jobs")
	public ResponseEntity <String> testmethod()
	{
		return new ResponseEntity <String> ("job Test controller",HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getalljobs")
	public ResponseEntity<ArrayList<Job>> getalljobs()
	{
		ArrayList<Job> listjobs=new ArrayList<Job>();
		listjobs=(ArrayList<Job>)jobDao.getalljob();
		return new ResponseEntity<ArrayList<Job>>(listjobs,HttpStatus.OK);
		
	}
	@PostMapping(value="/addjob")
	public ResponseEntity <String> createjob(@RequestBody Job job)
	{
		job.setPostDate(new java.util.Date());
		job.setStatus("NA");
		
		
		if(jobDao.addjob(job))
		{  return new ResponseEntity <String> ("job added",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in adding",HttpStatus.NOT_ACCEPTABLE);}
	
	}
	
	@DeleteMapping("/deletejob/{Id}")
	public ResponseEntity<String> deletejob (@PathVariable("Id")Integer jobId)
	{
		if(jobDao.deletejob(jobId))
		{return new ResponseEntity<String> ("job Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	
	@PutMapping(value="/editjob/{Id}")
	public ResponseEntity<String> editjob (@PathVariable("Id")Integer jobId,@RequestBody Job job)
	{
		Job newjob=jobDao.getjobById(jobId);
		newjob.setJobDesc(job.getJobDesc());
		newjob.setJobProfile(job.getJobProfile());
		newjob.setQualification(job.getQualification()); 
		if(jobDao.updatejob(newjob))
		 {return new ResponseEntity <String> ("job edited",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); }
	}
	
}
