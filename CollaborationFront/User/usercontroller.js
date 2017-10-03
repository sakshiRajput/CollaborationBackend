/**
 *User controller 
 */

app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore){
	$scope.registerUser=function()
	{
		console.log("user data is" +$scope.user)
		UserService.registerUser($scope.user).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/login')
		},function(response)
		{
			console.log(response.data)
			console.log(response.status)
			console.error=response.data
			$location.path('/register')
		}
		)
	}
	$scope.login=function()
	{
		console.log($scope.user)
		UserService.login($scope.user).then(function(response){
			$rootScope.currentUser=response.data
			$cookieStore.put('userDetails',response.data)
			$location.path('/')
		},function(response){
		
			$scope.error=response.data.messege
			$location.path('/login')
		})
	}
	if($rootScope.currentUser!=undefined){
		UserService.getuser().then(function(response){
			$scope.user=response.data
		},function(response){
			console.log(response.data)
		})
	}
	
});