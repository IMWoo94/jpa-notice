package com.example.jpa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.request.AddTeamRequest;
import com.example.jpa.dto.response.TeamResponse;
import com.example.jpa.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;

	@GetMapping("/teams")
	public ResponseEntity<List<TeamResponse>> getMembers() {
		return ResponseEntity.ok(teamService.getTeams());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeamResponse> getMemberById(@PathVariable Long id) {
		return ResponseEntity.ok(teamService.getTeamById(id));
	}

	@PostMapping
	public ResponseEntity<TeamResponse> addMember(@RequestBody AddTeamRequest addTeamRequest) {
		return ResponseEntity.ok(teamService.createdTeam(addTeamRequest));
	}
}
