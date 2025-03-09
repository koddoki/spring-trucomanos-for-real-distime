package com.t5n.trucomanos_for_real_distime.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PingPongController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting() throws Exception {
        return "SESSÃAAAAAAAAAAAAAAAAAAAAAAAAAAAO";
    }
}
