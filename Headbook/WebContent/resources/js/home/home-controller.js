//required: factories/factory-functions.js
(function(){
	
	angular
	.module('home')
	.controller('homeController', ['$scope', '$rootScope', 'ajaxFunctions', '$window', 'error', '$uibModal', function($scope, $rootScope, ajaxFunctions, $window, error, $uibModal){
		
		$scope.posts = [];
		$scope.loader = true;
		$scope.showLoader = false;
		
		$scope.init = function(){
			var callback = function(result){
				$scope.showLoader = false;
				if(result.data.state == "OK"){
					$scope.posts = result.data.data;
					$("#posts_list").css("display", "block")
				}
				else {
					error.showModal(result.data.message);
				}
			}
			$scope.showLoader = true;
			ajaxFunctions.realizarPedidoAjax({ url: "home/rest/getAllPosts", method: 'GET' }, callback);
		}
		
		$scope.newPost = function(){
			$window.location.href = './post/new';
		}
		
		$scope.like = function(post){
			var callback = function(result){
				if(result.data.state == "OK"){
					post.likesNumber = post.likesNumber + 1;
				}
				else {
					post.givenLike = post;
					error.showModal(result.data.message);
				}
			}
			post.givenLike = true;
			ajaxFunctions.realizarPedidoAjax({ url: "./post/rest/like", data: post, method: 'POST' }, callback);
		}
		
		$scope.showPostDetail = function(post) {
			$uibModal.open({
				templateUrl : '/Headbook/resources/views/home/post-detail_modal.html',
				controller : 'postDetailController',
				resolve : {
					post : function() {
						return post;
					}
				}
			});
		}
		
	}]);
	
})();