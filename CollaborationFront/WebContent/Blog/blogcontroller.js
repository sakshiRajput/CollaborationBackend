/**
 * BLOG CONTROLLER
 */
app.controller('BlogController',function($scope,BlogService,$location){
	$scope.postblog=function()
	{
		console.log("blog data is" +$scope.blog)
		BlogService.postblog($scope.blog).then(function(response){
			alert('blog added succesfully')
			console.log(response.data)
			console.log(response.status)
			$location.path('/')
		},function(response)
		{
			console.error=response.data
			if(response.status==401)
			{
				$location.path('/login')	
			}
			else
			$location.path('/addblog')
		}
		)
	}
	//approved blog---
	function blogsApproved(){
		BlogService.blogsApproved().then(function(response){
			$scope.listOfBlogsApproved=response.data
		},function(response){
			if(response.status=401)
				$location.path('/login')
		})
	}
	//functions---- blogs  waiting for approval
	function blogsWaitingForApproval(){
		BlogService.blogsWaitingForApproval().then(function(response){
			$scope.listOfBlogsWaitingForApproval=response.data
		},function(response){
			if(response.status=401)
				$location.path('/login')
		})
	}
	blogsApproved()
	blogsWaitingForApproval()
})