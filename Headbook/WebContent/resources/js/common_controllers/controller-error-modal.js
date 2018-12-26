(function() {

	angular.module('errorApp').controller('modalErrorController', [ '$scope', '$uibModalInstance', 'mensaje', function($scope, $uibModalInstance, mensaje) {

		if (mensaje != undefined){
			$scope.mensaje = mensaje;
		} else {
			$scope.mensaje = 'An unexpected error has happened.';
		}

		$scope.ok = function() {
			$uibModalInstance.close();
		};
	}]);

})();