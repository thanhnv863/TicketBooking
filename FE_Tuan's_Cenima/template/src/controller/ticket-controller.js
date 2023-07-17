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
        $scope.getTotalPages(); // Gọi hàm getTotalPages() sau khi cập nhật giá trị maxPage
      });
  };
  $scope.getTicketsByStatus = function (pageNo, status) {
    $http
      .get(
        "http://localhost:8080/ticket/get-ticket-by-status?pageNo=" +
          pageNo +
          "&status=" +
          status
      )
      .then(function (response) {
        $scope.tickets = response.data.content; // Lưu trữ danh sách vé
        $rootScope.maxPage = response.data.totalPages; // Tổng số trang
        $scope.getTotalPages(); // Gọi hàm getTotalPages() sau khi cập nhật giá trị maxPage
      });
  };
  $scope.getTotalPages = function () {
    $scope.pages = Array.from({ length: $rootScope.maxPage }, (_, i) => i);
  };

  $scope.goToPage = function (page) {
    if (page >= 0 && page <= $scope.maxPage) {
      $scope.currentPage = page;
      if (parseInt($scope.cbbStatusTicketFilter) === 3) {
        $scope.getTickets(page);
      }
      // $scope.getTickets(page);
      $scope.getTicketsByStatus(page, $scope.cbbStatusTicketFilter);
    }
  };

  $scope.getTotalPages();
  $scope.getTickets(0);
  $scope.filterTicketByStatus = function (status) {
    //cbb chojn all => value = 3 => getAll, chon printed => 1, unprinted => 2, khac => 4 => tam thoi cu set la get all tai chua nghi ra
    $scope.currentPage = 0;
    if (parseInt(status) === 3) {
      console.log("ua alo");
      $scope.getTickets(0);
    }
    $scope.getTicketsByStatus(0, status);
    console.log("Selected status:", status);
  };
};
