//required: factories/factory-functions.js
(function(){
	
	angular
	.module('post')
	.controller('postController', ['$scope', '$rootScope', 'ajaxFunctions', '$window', 'error', function($scope, $rootScope, ajaxFunctions, $window, error){
		
		$scope.showLoader = false;
		
		$scope.init = function(mode){
			$scope.mode = mode;
		}
		
		$scope.back = function(){
			$window.history.back();
		}
		
		$scope.createPost = function(form){
			if(form.$invalid)
				return;
			var callback = function(result){
				$scope.showLoader = false;
				if(result.data.state == "OK"){
					$window.location.href = '/Headbook/home';
				}
				else {
					error.showModal(result.data.message);
				}
			}
			$('.lds-ring').css("display", "block");
			$scope.showLoader = true;
			ajaxFunctions.realizarPedidoAjax({ url: "./rest/create", data: $scope.post, method: 'POST'}, callback);			
		}
		
	}]);
	
})();