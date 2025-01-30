package com.example.jpa.dto.request;

import com.example.jpa.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddMemberRequest {
	public String name;
	public Long teamId;

	public Member toEntity() {
		return Member.builder()
			.name(name)
			.build();
	}
}
