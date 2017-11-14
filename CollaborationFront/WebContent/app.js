/**
 * 
 */
var app = angular.module("myApp", ['ngRoute','ngCookies']);
app.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : 'Home/main.html'
    })
    .when('/login', {
        templateUrl : 'User/login.html',
        controller:'UserController'
    })
    .when('/register', {
        templateUrl : 'User/registration.html',
        controller:'UserController'
    })
    .when('/addblog', {
        templateUrl : 'Blog/addblog.html',
        controller:'BlogController'
    })
      .when('/success', {
        templateUrl : 'Home/success.html'
    
    })
    .when('/logout', {
        templateUrl : 'Home/success.html'
    
    })
    .when('/edituser', {
        templateUrl : 'User/edituser.html',
        controller:'UserController'
    
    })
    .when('/getblogs', {
        templateUrl : 'Blog/blogslist.html',
        controller:'BlogController'
    
    })
    .when('/getblogbyid/:id', {
        templateUrl : 'Blog/blogdetails.html',
        controller:'BlogDetailController'
    
    })
     .when('/getapproveform/:id', {
        templateUrl : 'Blog/blogapprovalform.html',
        controller:'BlogDetailController'
    
    })
    .when('/addjob', {
        templateUrl : 'Job/addjob.html',
        controller:'JobController'
    
    })
    .when('/getalljobs', {
        templateUrl : 'Job/joblist.html',
        controller:'JobController'
    
    })
    .when('/getsuggestedusers', {
        templateUrl : 'Friend/suggesteduser.html',
        controller:'FriendController'
    
    })
    .when('/friendlist', {
        templateUrl : 'Friend/friendlist.html',
        controller:'FriendController'
    
    })
    .when('/getpendingrequest', {
        templateUrl : 'Friend/pendingrequest.html',
        controller:'FriendController'
    
    })
    .when('/profilepic',{
		templateUrl:'ProfilePicture/uploadpicture.html'
		 
	})
	.when('/chat',{
		templateUrl:'Chat/chat.html',
		controller:'ChatController'
	})
	.when('/myprofile',{
		templateUrl:'User/profile.html',
			controller:'UserController'
	})
   .otherwise(
		   
	{  template:'<p>go to the corrent link..wrong address</p>'
	});
})

app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.currentUser==undefined)
	{	
			$rootScope.currentUser=$cookieStore.get('userDetails')
			console.log($cookieStore.get('userDetails'));
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
	}	
})