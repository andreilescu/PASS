'use strict';

	angular
		.module('pass')
		.controller('studentListController', studentListController);

	studentListController.$inject = ['$filter', 'studentFactory'];
	function studentListController($filter, studentFactory) {
		var vm = this;
		vm.students = {};
		vm.searchItem = "";
		vm.selectedStudent = false;
		vm.student = {};
		
		vm.averageRate = {};
		vm.daySucces = {};
		
		vm.numberOfHighAverageStudents = {};
		vm.showNumberOfHighAverageStudents = false;
		
		// api
		vm.loadStudents = loadStudents;
		vm.predictHoroscopeForStudent = predictHoroscopeForStudent;
		vm.predictNumberOfStudentsWithHighAverage = predictNumberOfStudentsWithHighAverage;
	
		function loadStudents() {
			studentFactory.all.get({}, function(data) {
				vm.students = data;
			})
		}
		
		function predictHoroscopeForStudent(student) {
			// config
			vm.student = student;
			vm.selectedStudent = true;
			
			vm.averageRate 	= predictAverageRate(vm.student);
			vm.daySucces 	= predictDaySucces(vm.student);
		}
		
		function predictNumberOfStudentsWithHighAverage(students) {
			vm.showNumberOfHighAverageStudents = true;
			var count = 0;
			var greatResult = 'greater +';
			
			for(var i=0; i<students.length;i++) {
				
				if(students[i].averageRate > 8) {
					var result = predictAverageRate(students[i]); 
					if(greatResult === result) {
						count++;
					} 
				}
			}
			
			vm.numberOfHighAverageStudents = count;
		}
		
		function predictAverageRate (student) {
			
			var numberOfCharactersName = student.name.length;
			numberOfCharactersName--;			
			
			var registrationNumberChar = student.registrationNumber.toString();
			var numberOfCharactersRegistrationNumber = registrationNumberChar.length;

			var sum = numberOfCharactersName + numberOfCharactersRegistrationNumber;
			var averageResult = {};
			
			if(sum % 2) {
				averageResult = 'greater +';
			} else {
				averageResult = 'lower -';
			}
			
			return averageResult;
		}
		
		function predictDaySucces(student) {
			
			var dateNumber 	= parseInt($filter('date')(new Date(), 'dd'));
			var letterNumber= parseInt(student.name.charCodeAt(0));
			
			var summ = dateNumber + letterNumber;
			var dayResult = {};
			
			if(summ % 2) {
				dayResult = 'great day :)';
			} else {
				dayResult = 'bad day :(';
			}
			
			return dayResult;
		}
	
		vm.loadStudents();
	}
