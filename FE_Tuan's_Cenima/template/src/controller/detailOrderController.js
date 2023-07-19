window.detailOrderController = function ($scope, $routeParams, $http) {
  $scope.listSalePayMent = [];
  $scope.listOrderTicket = [];
  $scope.listOrderSnack = [];
  $scope.listOrderTimeLine = [];
  var orderId = $routeParams.id;
  $http
    .get(ApiOrder + "get-one/" + orderId)
    .then(function (response) {
      if (response.status === 200) {
        $scope.orderDetail = response.data;
      }
    })
    .catch(function (error) {
      console.log(error);
    });
  // jquery
  $(document).ready(function () {
    var url = "http://localhost:8080/order-time-line/get-one/" + orderId; // Thêm orderId vào URL
    $.ajax({
      url: url,
      type: "GET",
      success: function (events) {
        var timeline = $(".timeline");
        for (var i = 0; i < events.length; i++) {
          var event = events[i];
          var eventHTML =
            '<div class="timeline-event ' +
            event.type +
            '">' +
            '<div class="timeline-icon">' +
            '<i class="mdi mdi-cart"></i>' +
            "</div>" +
            '<div class="timeline-date">' +
            event.createdTime +
            "</div>" +
            '<div class="timeline-description">' +
            event.type +
            "</div>" +
            "</div>";
          timeline.append(eventHTML);
        }
      },
      error: function () {
        console.error("Failed to fetch timeline events.");
      },
    });
  });
  // listOrderTicket
  $http.get(ApiOrderTicket + "list-order-ticket/" + orderId).then(
    function (response) {
      if (response.status === 200) {
        $scope.listOrderTicket = response.data;
      }
    },
    function (e) {
      console.log(e);
    }
  );
  // listOrderSnack
  $http.get(ApiOrderSnack + "list-order-snack/" + orderId).then(
    function (response) {
      if (response.status === 200) {
        $scope.listOrderSnack = response.data;
      }
    },
    function (e) {
      console.log(e);
    }
  );
  // mở frame
  $scope.openFrame = function openFrame() {
    var frameContainer = document.getElementById("frameContainer");
    frameContainer.style.display = "block";
  };

  $scope.closeFrame = function closeFrame() {
    var frameContainer = document.getElementById("frameContainer");
    frameContainer.style.display = "none";
  };
  //
  $http
    .get(ApiOrderTimeLine + "get-one/" + orderId)
    .then(function (response) {
      if (response.status === 200) {
        $scope.listOrderTimeLine = response.data;
      }
    })
    .catch(function (error) {
      console.log(error);
    });
};
