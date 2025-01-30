package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.dto.request.AddMemberRequest;
import com.example.jpa.dto.response.MemberResponse;
import com.example.jpa.entity.Member;
import com.example.jpa.entity.Team;
import com.example.jpa.exception.NotFoundMember;
import com.example.jpa.repositroy.MemberRepository;
import com.example.jpa.repositroy.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public List<MemberResponse> getMembers() {
		log.info("getMembers method called");
		List<MemberResponse> memberResponseList = new ArrayList<>();
		List<Member> members = memberRepository.findAll();
		members.stream().forEach(member -> {
			memberResponseList.add(MemberResponse.builder()
				.id(member.getId())
				.name(member.getName())
				.build());
		});
		return memberResponseList;
	}

	@Transactional(readOnly = true)
	public MemberResponse getMemberById(Long id) {
		log.info("getMemberById method called");
		MemberResponse memberResponse = memberRepository.findById(id)
			.map(member -> MemberResponse.builder()
				.id(member.getId())
				.name(member.getName())
				.build())
			.orElseThrow(() -> new NotFoundMember("존재하지 않는 사용자 입니다 :" + id));
		return memberResponse;
	}

	@Transactional
	public MemberResponse cratedMember(AddMemberRequest addMemberRequest) {
		log.info("cratedMember method called");
		Member save;
		Optional<Team> team = teamRepository.findById(addMemberRequest.getTeamId());
		if (team.isPresent()) {
			Member addMember = Member.builder()
				.name(addMemberRequest.getName())
				.team(team.get())
				.build();

			save = memberRepository.save(addMember);
		} else {
			save = memberRepository.save(addMemberRequest.toEntity());
		}

		return MemberResponse.builder()
			.id(save.getId())
			.name(save.getName())
			.build();
	}

}
