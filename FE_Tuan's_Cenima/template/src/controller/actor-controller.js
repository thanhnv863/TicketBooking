window.actorController = function ($rootScope, $http) {
  $rootScope.listActor = [];

  $http.get(ActorAPI + "/get-all").then(function (response) {
    $rootScope.listActor = response.data;
  });
};
