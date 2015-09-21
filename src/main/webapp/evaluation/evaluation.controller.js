'use strict';

angular.module('evaluationModule', ['ui.router'])
    .controller('EvaluationCtrl', function ($scope, $http) {

        $scope.result = "No results yet !!!!";

        $scope.evaluate = function () {
            var url = "http://localhost:8080/eval";
            $http.get(url,
                {
                    params: {
                        totalFuelConsumption: $scope.data.totalFuelConsumption,
                        fuelStandardEmission: $scope.data.fuelStandardEmission,
                        averageEmissionPerHousehold: $scope.data.averageEmissionPerHousehold,
                        householdNumber: $scope.data.householdNumber
                    }
                }
            )
                .
                success(function (response) {
                    $scope.result = response;
                })
        };
    }
);













