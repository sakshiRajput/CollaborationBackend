package com.collab.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.collab.CollaborationBack.Service.JobService;
import com.collab.CollaborationBack.model.Error;
import com.collab.CollaborationBack.model.Job;

@RestController
public class JobController {
	

	@Autowired
    private JobService jobService;
	@Autowired
	HttpSession session;
	
	@GetMapping(value="/jobs")
	public ResponseEntity <String> testmethod()
	{
		return new ResponseEntity <String> ("job Test controller",HttpStatus.OK);
	}
	
	@GetMapping(value="/getalljobs")
	public ResponseEntity<?> getalljobs(HttpSession session)
	{
		String username=(String)session.getAttribute("userName");
		if(username==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}


	    List<Job> listjobs=jobService.getalljob();
		return new ResponseEntity<List<Job>>(listjobs,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/addjob")
	public ResponseEntity <?> createjob(@RequestBody Job job,HttpSession session)
	{
		String userName=(String) session.getAttribute("userName");
	    System.out.println("user:-"+userName);
		if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		job.setPostDate(new java.util.Date());
		//job.setStatus("NA");
		try
		{ jobService.addjob(job);
		  return new ResponseEntity <Job> (job,HttpStatus.OK);
		 }
		catch(Exception e)
		{  Error error=new Error(9,"unable to add blog");
		   return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@DeleteMapping(value="/deletejob/{Id}")
	public ResponseEntity<String> deletejob (@PathVariable("Id")Integer jobId)
	{
		if(jobService.deletejob(jobId))
		{return new ResponseEntity<String> ("job Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	
	@PutMapping(value="/editjob/{Id}")
	public ResponseEntity<String> editjob (@PathVariable("Id")Integer jobId,@RequestBody Job job)
	{
	Job newjob=jobService.getjobById(jobId);
		newjob.setJobDesc(job.getJobDesc());
		//newjob.setJobProfile(job.getJobProfile());
		//newjob.setQualification(job.getQualification()); 
		if(jobService.updatejob(newjob))
		 {  return new ResponseEntity <String> ("job edited",HttpStatus.OK);  }
		 else
		 {
			 return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); 
		 }
	}
	@GetMapping(value="/getjobbyid/{id}")
	public ResponseEntity<?> getJobById(@PathVariable int id,HttpSession session)
	{
		String userName=(String) session.getAttribute("userName");
	    if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	   
	    Job job=jobService.getjobById(id);
	    return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}
}
