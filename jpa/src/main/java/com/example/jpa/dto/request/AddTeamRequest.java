package com.example.jpa.dto.request;

import com.example.jpa.entity.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddTeamRequest {
	public String name;

	public Team toEntity() {
		return Team.builder()
			.name(name)
			.build();
	}
}
