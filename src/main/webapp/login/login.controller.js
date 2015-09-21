'use strict';

angular.module('loginModule', ['ui.router'])
    .controller('loginController', ['$scope', '$rootScope', '$state', 'LoginService', function ($scope, $rootScope, $state, LoginService) {
        $scope.username = '';
        $scope.password = '';
        $scope.authenticate = authenticate;
        $rootScope.authenticate = false;

             function authenticate(){
                 var promise = LoginService.login($scope.username,$scope.password);
                 promise.then(function(result){
                     if(result.data.success){
                         $state.go('evaluate');
                         $rootScope.authenticate = true;

                     }
                     else {
                         $state.go('login');
                         $scope.message = result;
                     }

                 }, function() {
                     //erreur technique
                 })
             }
    }]);




