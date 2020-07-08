package com.webware.boot.pacific.roomwebapp;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RoomServices roomServices;
    private final Counter greetingCounter;

    @Autowired
    public ApiController(RoomServices roomServices, MeterRegistry registry){
        super();
        this.roomServices = roomServices;
        this.greetingCounter = Counter.builder("api.greeting").register(registry);
    }

    @GetMapping("greeting")
    public String getGreeting() {
        greetingCounter.increment();
        return "Hello Spring Learners";
    }

    @GetMapping("/rooms")
    @Timed(value="api.getAllRooms")
    public List<Room> getAllRooms(){
        return this.roomServices.getAllRooms();
    }
}
