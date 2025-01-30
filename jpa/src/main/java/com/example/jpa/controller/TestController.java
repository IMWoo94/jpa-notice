package com.example.jpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	@GetMapping
	public ResponseEntity<Void> hello() {
		log.info("hello");
		return ResponseEntity.ok().build();
	}
}
