/**
 * BLOG CONTROLLER
 */
app.controller('BlogController',function($scope,BlogService,$location){
	$scope.postblog=function()
	{
		console.log("blog data is" +$scope.blog)
		BlogService.postblog($scope.blog).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/success')
		},function(response)
		{console.log(response.data)
			console.log(response.status)
			console.error=response.data
			$location.path('/addblog')
		}
		)
	}
	
})