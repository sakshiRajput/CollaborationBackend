/**
 * user service
 */

app.factory('UserService',function($http){

	var userService={}
	var BASE_URL="http://localhost/CollaborationMiddle"
		userService.registerUser=function(user)
		{
		  return $http.post(BASE_URL + "/registeruser",user)
	    }
	    userService.login=function(user)
	    {
		  return $http.post(BASE_URL + "/login",user)
	    }
	
	    userService.logout=function(){
	    	return $http.put(BASE_URL+"/logout")
	    }
	    userService.getUser=function(){
	    	return $http.get(BASE_URL+"/getuser") 
	    }
	    
	    
	    return userService;
	
})