package com.gorani.membershipservice.application.port.in;

import common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public
class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

	@NotNull
	private final String name;

	@NotNull
	private final String email;

	@NotNull
	private final String address;

	private final boolean isCorp;

	private final boolean isValid;

	public RegisterMembershipCommand(
		String name, String email, String address, boolean isCorp, boolean isValid
	) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.isCorp = isCorp;
		this.isValid = isValid;
	}
}