window.orderController = function ($scope, $http, $window, $location) {
  $scope.listOrder = [];
  $http.get(ApiOrder + "get-all").then(
    function (response) {
      if (response.status === 200) {
        $scope.listOrder = response.data.content;
      }
    },
    function (e) {
      console.log(e);
    }
  );
  $scope.redirectToDetail = function (id) {
    $location.path("/detail/" + id);
  };
};
