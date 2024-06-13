package com.gorani.membershipservice.application.port.in;

import com.gorani.membershipservice.domain.Membership;

import common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {

	Membership registerMembership(RegisterMembershipCommand command);
}
