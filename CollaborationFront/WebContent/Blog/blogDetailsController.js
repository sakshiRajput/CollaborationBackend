
/**
 * BLOG DETAIL CONTROLLER
 */
app.controller('BlogDetailController',function($scope,BlogService,$location,$routeParams){
	$scope.isRejected=false
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
	
	$scope.showRejectionTxt=function(val){
		$scope.isRejected=val
	}
})