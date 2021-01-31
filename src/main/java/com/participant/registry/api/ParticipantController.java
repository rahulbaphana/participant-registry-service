package com.participant.registry.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class ParticipantController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World!");
    }
}
