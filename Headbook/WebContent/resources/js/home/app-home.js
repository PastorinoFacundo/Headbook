(function() { 
	angular.module('home', ['ajaxApp', 'errorApp'])
	.config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);
})();