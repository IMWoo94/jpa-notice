package com.example.jpa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.request.AddMemberRequest;
import com.example.jpa.dto.response.MemberResponse;
import com.example.jpa.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/members")
	public ResponseEntity<List<MemberResponse>> getMembers() {
		return ResponseEntity.ok(memberService.getMembers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
		return ResponseEntity.ok(memberService.getMemberById(id));
	}

	@PostMapping
	public ResponseEntity<MemberResponse> addMember(@RequestBody AddMemberRequest addMemberRequest) {
		return ResponseEntity.ok(memberService.cratedMember(addMemberRequest));
	}
}
