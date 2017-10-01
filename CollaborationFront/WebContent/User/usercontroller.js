/**
 *User controller 
 */

app.controller('UserController',function($scope,UserService,$location){
	$scope.registerUser=function()
	{
		console.log("user data is" +$scope.user)
		UserService.registerUser($scope.user).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/')
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
			$location.path('/')
		},function(response){
			console.error=response.data.message
			$location.path('/login')
		})
	}
})