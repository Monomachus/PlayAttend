import models.RoleEnum;
import models.User;

import org.junit.Test;

import play.libs.Codec;
import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

	@Test
	public void createUsers() {
		User bob = new User("bob", "123456");
		bob.create();

		assertEquals(bob.passwordHash, Codec.hexMD5("123456"));

		User martin = new User("MartinLuterKing", "qwerty");
		martin.create();

		assertEquals(martin.passwordHash, Codec.hexMD5("qwerty"));

		User superman = new User("superman", "infinity", RoleEnum.Admin);
		superman.create();

		assertEquals(superman.roleId, RoleEnum.Admin.ordinal());
	}

}
