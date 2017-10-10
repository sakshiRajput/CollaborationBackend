
/**
 * BLOG DETAIL CONTROLLER
 */
app.controller('BlogDetailController',function($scope,BlogService,$location,$routeParams){
	$scope.isLiked=false;
	$scope.isRejected=false;
	var id=$routeParams.id
	BlogService.getBlogById(id).then(function(response){
		$scope.blog=response.data
		console.log("new blog data-")
		console.log($scope.blog)
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	$scope.updateBlog=function(){
		BlogService.updateBlog($scope.blog).then(function(response){
			alert('blog updated succesfully')
			$location.path('/getBlogs')
		},function(response){
			console.log(response.status)
			if(response.status==401)
			$location.path('/login')
		})
	}
	$scope.updateLikes=function()
	{
		$scope.isLiked=!$scope.isLiked;
		if($scope.isLiked){
			$scope.blog.likes=$scope.blog.likes+1
		}
		else
			$scope.blog.likes=$scope.blog.likes-1
			BlogService.updateBlog($scope.blog).then(function(response){
				console.log(response.data)
			},function(response){
				console.log(response.status)
				if(response.status==401)
				$location.path('/login')
			})	
	}
	
	$scope.showRejectionTxt=function(val){
		$scope.isRejected=val
	}
})