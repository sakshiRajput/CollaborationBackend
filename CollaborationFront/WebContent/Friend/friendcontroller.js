/**
 * FRIEND CONTROLLER
 */

app.controller('FriendController',function($scope,FriendService,$location){
	
	function listOfSuggestedUsers(){
		FriendService.listOfSuggestedUsers().then(function(response){
			$scope.suggestedUsers=response.data
		},function(response){
			if(response.status=401)
				$location.path('/login')
		})
	}
	
	function pendingRequests(){
		FriendService.pendingRequests().then(function(response){
			$scope.pendingRequests=response.data
		},function(response){
			if(response.status=401)
				$location.path('/login')
		})
	}
	function listOfFriends()
	{
		FriendService.listOfFriends().then(function(response){
			alert('List of Friends')
			$scope.listOfFriends=response.data;
		},function(response){
			if(response.status=401)
				$location.path('/login')
		
		})
	}
	
	$scope.sendFriendRequest=function(toId){
		FriendService.sendFriendRequest(toId).then(function(response){
			alert('Friend Request send!!!')
			listOfSuggestedUsers()
			$location.path('/getsuggestedusers')
		},function(response){
			if(response.status=401)
				$location.path('/login')
		})
	}
	
	$scope.updatePendingRequest = function(request,statusValue){
		console.log(statusValue)
		request.status=statusValue;
		console.log(request.status)
		FriendService.updatePendingRequest(request).then(function(response){
			pendingRequests()
			console.log(request.status)
			listOfFriends()
			$location.path('/friendlist')
		
		},function(response){
			
		})
	
	}
	
	listOfSuggestedUsers()
	pendingRequests()
	listOfFriends()
})