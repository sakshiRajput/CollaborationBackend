/**
 * JOB SERVICE
 */
app.factory('JobService',function($http){
	
	var jobService={}
	var BASE_URL="http://localhost/CollaborationMiddle"
	jobService.addjob=function(job)
	{
	return $http.post(BASE_URL+"/addjob",job)
	}
	jobService.getalljobs=function()
	{
	return $http.get(BASE_URL+"/getalljobs")
	}
	jobService.getJobDetails=function(jobId)
	{
		return $http.get(BASE_URL+"/getjobbyid/"+jobId)
	}  
	
	return jobService;
})
