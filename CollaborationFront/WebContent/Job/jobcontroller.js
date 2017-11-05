/**
 *JOB CONTROLLER 
 */
app.controller('JobController',function($scope,JobService,$location){
	console.log("job Controller");
	
	var self = this;
	$scope.showJobDetails=false;
	self.job = {
			jobDesc : '',
			jobTitle : '',
			skillsRequired: '',
			salary : '',
			location : '',
			companyName : ''
	};
	
	self.addjob = function(job){
		console.log("add a new job");
		JobService.addjob(job).then(function(d){
			alert('new job added!!')	
			console.log(d)
			self.job = d;
			$location.path('/')
			},function(response){
				console.error=response.data
				console.error('Error While adding New job.');
				$location.path('/addjob')
			});
	};
	
	self.submit = function(){
		{
    		console.log('Saving a New job',self.job);
    		self.addjob(self.job);            			
		}
		self.reset();
	};
	
	self.reset = function(){
		self.job  = {
				jobId : '',
				jobDesc : '',
    			jobTitle : '',
    			salary : '',
    			companyName : '',
    			location : '',
    			skillsRequired : '',
    			postDate : ''
    			
		};
		$scope.form.$setPristine();
	};
	
	function getalljobs()
	{
		JobService.getalljobs().then(function(response){
			console.log(response.data)
			$scope.jobs=response.data
		},function(response){
			if(response.status==401)
			{	$location.path('/login')  }
			
				
		})
		
	}
	
	$scope.getJobDetails=function(jobId){
		$scope.showJobDetails=true
		JobService.getJobDetails(jobId).then(function(response){
			console.log(response.data)
			$scope.job=response.data
		},function(response){
			console.log(response.data)
			if(response.status==401)
			{	$location.path('/login')  }
			
		})
		
	}
	getalljobs()
})

