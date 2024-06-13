package com.gorani.membershipservice.adapter.out.persistence;

import com.gorani.membershipservice.application.port.out.RegisterMembershipPort;
import com.gorani.membershipservice.domain.Membership;

import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;

	@Override
	public MembershipJpaEntity createMembership(
		Membership.MembershipName membershipName
		, Membership.MembershipEmail membershipEmail
		, Membership.MembershipAddress membershipAddress
		, Membership.MembershipIsValid membershipIsValid
		, Membership.MembershipIsCorp membershipIsCorp
	) {
		return membershipRepository.save(
			new MembershipJpaEntity(
				membershipName.getName(),
				membershipAddress.getAddress(),
				membershipEmail.getEmail(),
				membershipIsValid.isValid(),
				membershipIsCorp.isCorp()
			)
		);
	}
}
