
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
	$scope.addComment=function(){
		console.log($scope.blogComment)
		$scope.blogcomment.blog=$scope.blog//blog prop in blogcommnt
		console.log($scope.blogcomment)
		BlogService.addComment($scope.blogcomment).then(function(response){
			//getBlogComments()
			alert('your comment is posted succesfully')
			console.log(response.data)
			console.log(response.status)
			
		},function(response){
			console.log(response.status)
			if(response.status==401)
				$location.path('/login')
				else
					$location.path('/getblogbyid'+id)
					
		})
	}
	function getBlogComments(){
		BlogService.getBlogComments(id).then(function(response){
			$scope.blogcomments=response.data//list of blogcomments
		},function(response){
			if(response.status==401)
				$location.path('/login')
		})
	}
	getBlogComments()
})