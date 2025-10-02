package api;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface UserNetworkAPI {

	UserInput request(UserInput userInput);

	InputVerified check(UserInput input);

}
