(function() {
	angular.module('home').controller('postDetailController', [ '$scope', '$uibModalInstance', 'post', function($scope, $uibModalInstance, post) {

			$scope.post = post;

		$scope.ok = function() {
			$uibModalInstance.close();
		};
	}]);

})();