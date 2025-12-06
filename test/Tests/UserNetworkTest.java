package Tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import api.InputVerified;
import api.NetworkResponse;
import api.UserInput;
import api.UserNetwork;
import implementations.UserNetworkImpl;

public class UserNetworkTest {

	@Test
	public void inputVerifiedTest() {
		UserNetwork api = Mockito.mock(UserNetworkImpl.class);

		UserInput input = Mockito.mock(UserInput.class);

		InputVerified verified = api.check(input);

		assertNotNull(verified, "good input");

	}

	@Test
	public void networkResponseTest() {
		UserNetwork api = Mockito.mock(UserNetworkImpl.class);
		UserInput input = Mockito.mock(UserInput.class);

		InputVerified verified = Mockito.mock(InputVerified.class);

		NetworkResponse response = api.answer(verified, input);

		assertNotNull(response, "Start Calculating!!");

	}
}
