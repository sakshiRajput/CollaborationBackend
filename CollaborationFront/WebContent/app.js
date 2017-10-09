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
   
   .otherwise(
	{  template:'<p>go to the corrent link..wrong address</p>'
	});
})

app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.currentUser==undefined)
	{	
			$rootScope.currentUser=$cookieStore.get('userDetails')
			console.log($cookieStore.get('userDetails'));
	}	
})