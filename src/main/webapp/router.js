'use strict';

angular
    .module('myApp', ['loginModule', 'evaluationModule', 'ui.router'])
    .config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('site', {
                url: '/',
                views: {
                    'navbar@': {
                        templateUrl: 'index.navbar.html'
                    }
                }
            })
    }]);





