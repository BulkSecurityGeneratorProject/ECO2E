'use strict';

angular.module('loginModule')
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider) {
            $stateProvider
                .state('login', {
                    url: '/login',
                    parent: "site",
                    views: {
                        'content@': {
                            templateUrl: 'login/login.html',
                            controller: 'loginController'
                        }
                    }
                })
        }]);




