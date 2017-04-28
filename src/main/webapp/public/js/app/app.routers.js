/**
 * 
 */
app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/event', {templateUrl: APP_URL+'/event/', controller: 'EventCtrl'});
  $routeProvider.when('/lock', {templateUrl: APP_URL+'/lock/', controller: 'LockCtrl'});
  $routeProvider.when('/device', {templateUrl: APP_URL+'/device/', controller: 'DeviceCtrl'});
  $routeProvider.when('/type', {templateUrl: APP_URL+'/type/', controller: 'TypeCtrl'});
  $routeProvider.when('/cmd', {templateUrl: APP_URL+'/cmd/', controller: 'CmdCtrl'});
  $routeProvider.when('/water', {templateUrl: APP_URL+'/water/', controller: 'WaterCtrl'});
  $routeProvider.when('/lockUser', {templateUrl: APP_URL+'/lockUser/', controller: 'LockUserCtrl'});
  $routeProvider.when('/lockLock', {templateUrl: APP_URL+'/lock/lock', controller: 'LockLockCtrl'});
  $routeProvider.when('/log', {templateUrl: APP_URL+'/log/', controller: 'LogCtrl'});
  $routeProvider.when('/power', {templateUrl: APP_URL+'/power/', controller: 'PowerCtrl'});
  $routeProvider.when('/system', {templateUrl: APP_URL+'/system/', controller: 'SystemCtrl'});
  $routeProvider.when('/errorview', {template: '功能开发中', controller: ''});
  $routeProvider.otherwise({redirectTo: '/errorview'});
}]);