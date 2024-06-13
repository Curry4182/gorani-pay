package com.gorani.membershipservice.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.gorani.membershipservice.domain.Membership;

@Component
public class MembershipMapper {
	public Membership mapToDomainEntity(MembershipJpaEntity membership) {
		return Membership.generateMember(
			new Membership.MembershipId(membership.getMembershipId()+""),
			new Membership.MembershipName(membership.getName()),
			new Membership.MembershipEmail(membership.getEmail()),
			new Membership.MembershipAddress(membership.getAddress()),
			new Membership.MembershipIsValid(membership.isValid()),
			new Membership.MembershipIsCorp(membership.isCorp())
		);
	}
}
