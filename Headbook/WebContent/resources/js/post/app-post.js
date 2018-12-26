(function() { 
	angular.module('post', ['ajaxApp', 'errorApp'])
	.config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);
})();