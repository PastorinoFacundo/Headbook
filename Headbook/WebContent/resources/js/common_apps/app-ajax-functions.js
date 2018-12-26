(function() {
	angular.module('ajaxApp', ['ui.bootstrap', 'errorApp' ]).factory('ajaxFunctions', [ '$http', '$rootScope','$location', 'error', function($http, $rootScope, $location, errorManager) {

		var optionsSend = {
			data : "",
			dataType : "json",
			withCredentials : false,
			headers : {
				'Content-Type' : 'application/json; charset=utf-8'
			},
			async : true
		}

		var realizarPedidoAjax = function realizarPedidoAjax(options, functionSuccessOk) {
			
			angular.extend(optionsSend, options);

			if(!optionsSend.async){
				$rootScope.loader = true;				
			}
			pedidoAjax = $http({
				url : optionsSend.url,
				data : optionsSend.data,
				method : optionsSend.method,
				dataType : optionsSend.dataType,
				withCredentials : optionsSend.withCredentials,
				headers : optionsSend.headers,
				async : optionsSend.async
			}).then(function(data) {
				$rootScope.loader = false;
				if(data.hasOwnProperty("data")){
					functionSuccessOk(data);					
				}
				
			},function (error){
				$rootScope.loader = false;
				errorManager.showModal(error)
			   });
			
			return pedidoAjax;
		}
		
		return {
			realizarPedidoAjax : realizarPedidoAjax,
		}
	} ]);

})();