package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.dto.request.AddTeamRequest;
import com.example.jpa.dto.response.TeamResponse;
import com.example.jpa.entity.Team;
import com.example.jpa.exception.NotFoundTeam;
import com.example.jpa.repositroy.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

	private final TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public List<TeamResponse> getTeams() {
		log.info("getTeams method called");
		List<TeamResponse> teamResponseList = new ArrayList<>();
		List<Team> teams = teamRepository.findAll();
		teams.stream().forEach(member -> {
			teamResponseList.add(TeamResponse.builder()
				.id(member.getId())
				.name(member.getName())
				.build()
			);
		});
		return teamResponseList;
	}

	@Transactional(readOnly = true)
	public TeamResponse getTeamById(Long id) {
		log.info("getMemberById method called");
		TeamResponse teamResponse = teamRepository.findById(id)
			.map(member -> TeamResponse.builder()
				.id(member.getId())
				.name(member.getName())
				.build())
			.orElseThrow(() -> new NotFoundTeam("존재하지 않는 팀 입니다 :" + id));
		return teamResponse;
	}

	@Transactional
	public TeamResponse createdTeam(AddTeamRequest addTeamRequest) {
		log.info("createdTeam method called");
		Team team = teamRepository.save(addTeamRequest.toEntity());

		return TeamResponse.builder()
			.id(team.getId())
			.name(team.getName())
			.build();
	}

}
