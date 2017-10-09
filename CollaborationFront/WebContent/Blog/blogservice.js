/**
 * BLOG SERVICE
 */
app.factory('BlogService',function($http){

	var blogService={}
	var BASE_URL="http://localhost/CollaborationMiddle"
	blogService.postblog=function(blog)
		{
		  return $http.post(BASE_URL + "/createblog",blog)
	    }
	blogService.blogsWaitingForApproval=function(){
		return $http.get(BASE_URL+"/getblogs/"+"NA")
	}
	blogService.blogsApproved=function(){
		return $http.get(BASE_URL+"/getblogs/"+"A")
	}
	blogService.getBlogById=function(id){
		return $http.get(BASE_URL+"/getblogbyid/"+id)
	}  
	blogService.updateBlog=function(blog){
		return $http.put(BASE_URL + "/update",blog)	
	}
	return blogService;
	
})