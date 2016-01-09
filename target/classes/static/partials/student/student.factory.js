'use strict'

	angular
		.module('pass')
		.factory('studentFactory', studentFactory);
	
	studentFactory.$inject = ['$resource'];
	function studentFactory($resource) {
						return {
								all 	: 	$resource('student', {}, 
														{
																'get': 		{method: 'GET', isArray: true}
														}
								),
								oneById :	$resource('student/:registrationNumber', {registrationNumber: '@registrationNumber'}, 
														{
																'get': 		{method: 'GET'}
														}
								)
						}
	}
