package com.example.be.employee.controller;

import com.example.be.employee.message.request.ChairTypeRequest;
import com.example.be.entity.ChairType;
import com.example.be.service.ChairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ChairTypeControllerWebsocket {
    @Autowired
    private ChairTypeService chairTypeService;

    @GetMapping("/get-all-chair-type")
    public List<ChairType> getAll() {
        return chairTypeService.getAll();
    }

    @MessageMapping("/save-chair-type")
    @SendTo("/result/save-chair-type")
    public ChairType saveChair(@RequestBody ChairTypeRequest chairTypeRequest) {
        return chairTypeService.save(chairTypeRequest);
    }
}
//Annotation @MessageMapping xác định đường dẫn của tin nhắn
// mà phương thức sẽ xử lý
// khi một tin nhắn được gửi đến đường dẫn "/save-chair",
// phương thức saveChair() sẽ được gọi để xử lý tin nhắn đó.
//@SendTo("/topic/public"):
//
//Annotation @SendTo xác định đích mà kết quả của phương thức sẽ được gửi tới.
//Trong trường hợp này, kết quả của phương thức sendMessage() sẽ được gửi tới đích "/topic/public".
