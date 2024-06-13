package com.gorani.membershipservice.application.port.out;

import com.gorani.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.gorani.membershipservice.domain.Membership;

public interface RegisterMembershipPort {

	MembershipJpaEntity createMembership(
		Membership.MembershipName membershipName,
		Membership.MembershipEmail membershipEmail,
		Membership.MembershipAddress membershipAddress,
		Membership.MembershipIsValid membershipIsValid,
		Membership.MembershipIsCorp membershipIsCorp
	);
}
