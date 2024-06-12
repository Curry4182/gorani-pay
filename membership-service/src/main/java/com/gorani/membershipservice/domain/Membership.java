package com.gorani.membershipservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/*
*  오염이 되면 안되는 클래스
*  핵심 도메인 객체
* */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

	@Getter private final String membershipId;

	@Getter private final String name;

	@Getter private final String email;

	@Getter private final String address;

	@Getter private final boolean isValid;

	@Getter private final boolean isCorp;

	@Value
	public static class MembershipId {

		public MembershipId(String value) {
			this.membershipId = value;
		}

		String membershipId;
	}

	@Value
	public static class MembershipName {

		public MembershipName(String value) {
			this.name = value;
		}

		String name;
	}

	@Value
	public static class MembershipEmail {

		public MembershipEmail(String value) {
			this.email = value;
		}

		String email;
	}

	@Value
	public static class MembershipAddress {

		public MembershipAddress(String value) {
			this.address = value;
		}

		String address;
	}

	@Value
	public static class MembershipIsValid {

		public MembershipIsValid(boolean value) {
			this.isValid = value;
		}

		boolean isValid;
	}

	@Value
	public static class MembershipIsCorp {

		public MembershipIsCorp(boolean value) {
			this.isCorp = value;
		}

		boolean isCorp;
	}

	public static Membership generateMember(
		MembershipId membershipId,
		MembershipName name,
		MembershipEmail email,
		MembershipAddress address,
		MembershipIsValid isValid,
		MembershipIsCorp isCorp
	) {
		return new Membership(
			membershipId.getMembershipId(),
			name.getName(),
			email.getEmail(),
			address.getAddress(),
			isValid.isValid(),
			isCorp.isCorp()
		);
	}
}
