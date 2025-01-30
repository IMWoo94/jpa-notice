package com.example.jpa.dto.response;

import lombok.Builder;

@Builder
public class MemberResponse {
	public Long id;
	public String name;
	public TeamResponse team;
}
