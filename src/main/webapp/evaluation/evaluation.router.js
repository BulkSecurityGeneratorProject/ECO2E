'use strict';

angular.module('evaluationModule')
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider) {

            $stateProvider
                .state('evaluate', {
                    url: '/evaluate',
                    parent: "site",
                    views: {
                        'content@': {
                            templateUrl: 'evaluation/evaluation.html',
                            controller: 'EvaluationCtrl'
                        }
                    }
                })
        }]);













