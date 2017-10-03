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
	   
	return blogService;
	
})