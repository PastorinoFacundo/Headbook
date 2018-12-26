(function() {
	angular.module('errorApp', ['ui.bootstrap']).factory('error', [ '$uibModal', function($uibModal) {

		var showModal = function(message) {
			$uibModal.open({
				templateUrl : '/Headbook/resources/views/commons/modal_error.html',
				controller : 'modalErrorController',
				resolve : {
					mensaje : function() {
						return message;
					}
				}
			});
		}
		
		return {
			showModal : showModal,
		}
	} ]);

})();