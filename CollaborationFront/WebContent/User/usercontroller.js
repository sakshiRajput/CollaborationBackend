
/**
 * Angular JS userController
 */
app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore){

	$scope.registerUser=function()
	{
		/*
		 * call user service by passing data in JSON FORMAT
		 */
		console.log("USER- "+$scope.user);
		
		UserService.registerUser($scope.user).then(function(response){
			console.log(response.data);
			console.log(response.status);
			$location.path('/');
			
		},function(response){
			console.log(response.data);
			console.log(response.status);
			$scope.error=response.data;
			$location.path('/register');
		})
		
	}
	$scope.login = function()
	{
		console.log ("User-");
		console.log ($scope.user);
		UserService.login($scope.user).then(function(response){
			
			$rootScope.currentUser=response.data; // accessing variable username from here 
			$cookieStore.put('userDetails',response.data);
			console.log(response.data);
			console.log(response.status);
			$location.path('/');
		},function(response){
			$scope.error=response.data;
			$location.path('/login');
		})
	}
	
	if($rootScope.currentUser!=undefined){
	UserService.getUser().then(function(response){
		$scope.user=response.data;
	
	},function(response){
		
	})
	}

	$scope.updateUser = function(){
		UserService.updateUser($scope.user)
				.then(function(response){
					alert(" Successfully Updated");
					$location.path('/');
				},function(response){
					if(response.status==401)
					{
					$location.path('/login')
					}
				else{
					$scope.error = response.data;
			    	$location.path('/edituser')
				}
				})
	}
	$rootScope.logout = function(){
		delete $rootScope.currentUser;
		UserService.logout()
		.then(function(response){
			
			$cookieStore.remove('userDetails');
			$location.path('/login');
		},function(response){
			if(response.status==401)
			{
				console.log(response.message);
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails');
				$location.path('/login');
			}
			})
	}
});