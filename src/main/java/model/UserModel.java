package model;

import lombok.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class UserModel {

	@Builder.Default
	private String firstName = "John";

	@Builder.Default
	private String lastName = "Doe";

	@Builder.Default
	private String email = randomAlphabetic(6,10).concat("@gmail.com");

	@Builder.Default
	private String password = randomAlphabetic(10);

	@Builder.Default
	private String phone = "097965544333";

	@Builder.Default
	private String home_phone = "097965544333";

	@Builder.Default
	private String address1 = "801 Tom Martin Dr.Birmingham";

	@Builder.Default
	private String address2 = "AL 35211";

	@Builder.Default
	private String city = "Birmingham";

	@Builder.Default
	private String postcode = "88443";

	@Builder.Default
	private String addressAlias = "AL35211";

	@Builder.Default
	private int dayBirth = 15;

	@Builder.Default
	private int monthBirth = 12;

	@Builder.Default
	private int yearBirth = 1988;

	@Builder.Default
	private int state = 1;
}