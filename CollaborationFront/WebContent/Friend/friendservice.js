/**
 * FRIEND SERVICE
 */
app.factory('FriendService',function($http){

	var friendService={}
	var BASE_URL="http://localhost/CollaborationMiddle"
    friendService.listOfSuggestedUsers=function()
    {
		return $http.get(BASE_URL+"/getsuggestedusers")
    }

	friendService.sendFriendRequest=function(toId)
    {
		return $http.get(BASE_URL+"/friendRequest/"+toId)
    }
	friendService.pendingRequests=function()
    {
		return $http.get(BASE_URL+"/pendingRequests")
    }
	friendService.listOfFriends=function()
	{
		return $http.get(BASE_URL+"/listOfFriends")
	}
	friendService.updatePendingRequest=function()
	{
		return $http.put(BASE_URL+"/updatePendingRequests")
	}
    return friendService;
})