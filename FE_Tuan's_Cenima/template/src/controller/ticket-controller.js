window.ticketController = function ($scope, $http, $rootScope) {
  $scope.tickets = [];
  $scope.currentPage = 0;
  $rootScope.maxPage = 0;
  $scope.pages = [];
  $scope.currentPage = 0;

  $scope.getTickets = function (pageNo) {
    $http
      .get("http://localhost:8080/ticket/get-all?pageNo=" + pageNo)
      .then(function (response) {
        $scope.tickets = response.data.content; // Lưu trữ danh sách vé
        $rootScope.maxPage = response.data.totalPages; // Tổng số trang
        console.log("huuu: " + $rootScope.maxPage);
        $scope.getTotalPages(); // Gọi hàm getTotalPages() sau khi cập nhật giá trị maxPage
      });
  };
  $scope.getTotalPages = function () {
    $scope.pages = Array.from({ length: $rootScope.maxPage }, (_, i) => i);
  };

  $scope.goToPage = function (page) {
    if (page >= 0 && page <= $scope.maxPage) {
      $scope.currentPage = page;
      $scope.getTickets(page);
    }
  };
  console.log("huuu: " + $scope.pages);
  console.log("huuu: " + $rootScope.maxPage);

  $scope.getTotalPages();
  $scope.getTickets(0);
};
