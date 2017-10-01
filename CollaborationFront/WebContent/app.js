/**
 * 
 */
var app = angular.module("myApp", ['ngRoute']);
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
	.otherwise(
	{  template:'<p>go to the corrent link..wrong address</p>'
	});
});