package com.example.be.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {
    //phuong thuc: registerStompEndpoints: dang ki mot dia chi
    //websocket endpoint va kich hoat SockJS (mot thu vien js ho tro websocket)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-ticket-booking").setAllowedOrigins("http://127.0.0.1:5500").withSockJS();
        //"/ws-ticket-booking" la dia chi websocket endpoint ma client ket noi den
        //setAllowedOrigins("http://127.0.0.1:5500"): chi cho phep ket noi den tu domain
        //"http://127.0.0.1:5500" (live server)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //enableSimpleBroker: dang ki duong di (path) cho message broker
        //day la duong di ma server se su dung de gui tin nhan den client.
        //'/result': la duong dan duoc dang ki
        registry.enableSimpleBroker("/result");
        //setApplicationDestinationPrefixes: dang ki tien to prefix
        //cho cac message mapping den server
        //=> tat ca cac message mapping den server phai co tien to /ticket-booking
        registry.setApplicationDestinationPrefixes("/ticket-booking");
    }
}
// việc đăng ký điểm cuối registerStompEndpoints là cách để máy khách tìm thấy và
// kết nối với ứng dụng WebSocket.
//Khi máy khách muốn kết nối với ứng dụng Websocket,
// nó có thể sử dụng đường dẫn "/ws-ticket-booking" để thiết lập kết nối
// WebSocket tới ứng dụng.
// Điểm cuối Stomp được đăng ký cho phép máy khách gửi
// và nhận các tin nhắn thông qua giao thức
// Stomp (Simple/Streaming Text Oriented Messaging Protocol)
// thông qua kết nối WebSocket.