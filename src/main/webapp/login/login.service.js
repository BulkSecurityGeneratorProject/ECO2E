'use strict';

angular
    .module('loginModule')
    .factory('LoginService', ['$http', function ($http) {
        var service = {};

        service.login = function (username, password) {
            var data = 'j_username=' + encodeURIComponent(username) +
                    '&j_password=' + encodeURIComponent(password)
            //+ '&remember-me=' + credentials.rememberMe + '&submit=Login'
                ;
            return $http.post('/api/authentication', data, {

                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            });
        };
        return service;
    }]);