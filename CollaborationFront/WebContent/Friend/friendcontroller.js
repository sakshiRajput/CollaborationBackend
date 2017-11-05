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
	
	$scope.updatePendingRequest=function(request,statusValue){
		console.log(request)
			console.log(request.status)
		request.status=statusValue
		console.log(request.status)
		FriendService.updatePendingRequest(request,statusValue).then(function(response){
			alert('List of Pending Request')
			pendingRequests()
			$location.path('/pendingrequests')
		},function(response){
			alert('error in pending request')
			if(response.status=401)
				$location.path('/login')
		})
	}
	
	listOfSuggestedUsers()
	pendingRequests()
	listOfFriends()
})