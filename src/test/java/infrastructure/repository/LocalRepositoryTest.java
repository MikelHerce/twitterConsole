package infrastructure.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import domain.User;
import domain.user.UserBuilder;

public class LocalRepositoryTest {

	private UserRepository userRepository;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		userRepository = new LocalRepository();
	}
	
	
	
	@Test
	public void should_return_info_existing_user() throws UserNotFoundException {
		// given
		User anExistingUser = UserBuilder.aUser().withName("Alice").build();
		// when
		User recoveredUser = userRepository.getUser(anExistingUser.getName());
		// then
		assertEquals(anExistingUser.getName(), recoveredUser.getName());
	}

	@Test(expected = UserNotFoundException.class)
	public void should_throw_User_not_found_exception() throws UserNotFoundException {
		userRepository.getUser("");
	}
	
	@Test
	public void should_update_info() throws UserNotFoundException {
		// given
		User anExistingUser = UserBuilder.aUser().withName("Alice").build();
		// when
		anExistingUser.setTweets(null);
		User recoveredUser = userRepository.persist(anExistingUser);
		// then
		assertEquals(anExistingUser.getName(), recoveredUser.getName());
	}
	@Test
	public void should_create_one_new_user() throws UserNotFoundException {
		// given
		User aNewUser = UserBuilder.aUser().withName("newUser").build();
		// when
		userRepository.persist(aNewUser);
		// then
		assertEquals(4, userRepository.getAll().size());
	}
	

}
