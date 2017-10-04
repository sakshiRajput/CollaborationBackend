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
	.otherwise(
	{  template:'<p>go to the corrent link..wrong address</p>'
	});
})

app.run(function($rootScope,$cookieStore,UserService,$location)
{
	if ($rootScope.currentUser==undefined)
	{	$rootScope.currentUser=$cookieStore.get('userDetails')  }
		
		$rootScope.logout=function()
		{   	delete $rootScope.currentUser;
		    UserService.logout().then(function(response){
			
			$cookieStore.remove('userDetails')
			$location.path('/login')
	    	},function(response){
			if(response.status==401){
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails');
		     	$location.path('/')
			}
		})
		}
	})