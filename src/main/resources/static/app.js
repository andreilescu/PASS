'use strict';
	
	angular
		.module('pass', ['ngRoute', 'ngResource'])
		.config(function($routeProvider) {
			
					$routeProvider.when('/', {
							redirectTo : '/student'		
						})
						.when('/student', {
							controller : 'studentListController',
							templateUrl: 'partials/student/student.list.html',
							controllerAs: 'vm'
						});
				}
);