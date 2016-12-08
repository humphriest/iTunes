var itunesParser = angular.module('itunesParser', ['ngRoute']);

itunesParser.config(function($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl : 'views/home.html',
            controller  : 'MainController'
        })
        .when('login', {
            templateUrl : 'views/login.html',
            controller : 'LoginController'
        });

        // route for the about page
        /*.when('/about', {
            templateUrl : 'pages/about.html',
            controller  : 'aboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'pages/contact.html',
            controller  : 'contactController'
        });*/
});

// create the controller and inject Angular's $scope
itunesParser.controller('MainController', function($scope) {

$scope.welcomeMessage = "Hello and Welcome";
});