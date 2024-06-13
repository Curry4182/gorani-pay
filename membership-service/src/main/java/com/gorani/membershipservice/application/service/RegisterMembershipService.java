package com.gorani.membershipservice.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gorani.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.gorani.membershipservice.adapter.out.persistence.MembershipMapper;
import com.gorani.membershipservice.application.port.in.RegisterMembershipCommand;
import com.gorani.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.gorani.membershipservice.application.port.out.RegisterMembershipPort;
import com.gorani.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterMembershipService implements RegisterMembershipUseCase {

	private final RegisterMembershipPort registerMembershipPort;

	private final MembershipMapper membershipMapper;

	@Override
	public Membership registerMembership(RegisterMembershipCommand command) {

		MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);

		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}

