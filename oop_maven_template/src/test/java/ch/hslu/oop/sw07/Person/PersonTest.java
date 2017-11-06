/**
 * 
 */
package ch.hslu.oop.sw07.Person;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.*;

import ch.hslu.oop.sw07.Person.Person;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Daveeee
 *
 */
public class PersonTest {
	private static int testcounter;
	private static Person person;
	private static final long id = 234564L;
	private static final String firstName = "Max";
	private static final String lastName = "Mustermann";

	@BeforeClass
	public static void setBefore() {
		person = new Person(id, firstName, lastName);
		testcounter = 0;
		System.out.println("Tests starting now...");
	}

	@Before
	public void before() {
		testcounter++;
		System.out.println("Test " + testcounter + " has started...");
	}

	@After
	public void after() {
		System.out.println("Test " + testcounter + " has ended...");
	}

	@AfterClass
	public static void setAfter() {
		System.out.println("Tests ended...");
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Person.Person#Person(long, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPerson() {
		new Person(id, firstName, lastName);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#getFirstname()}.
	 */
	@Test
	public void testGetFirstname() {
		assertEquals(firstName, person.getFirstname());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#getLastname()}.
	 */
	@Test
	public void testGetLastname() {
		assertEquals(lastName, person.getLastname());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(id, person.getId());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("Person-Objekt mit Namen: Max und Nachnamen: Mustermann und ID: 234564", person.toString());
	}

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Person.class).verify();
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	@Ignore
	public void testEqualsTrue() {
		Person person1 = new Person(123L, "Herbert", "Herder");
		Person person2 = (Person) person1;
		assertTrue(person1.equals(person2));
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	@Ignore
	public void testEqualsFalse() {
		Person person1 = new Person(123L, "Herbert", "Herder");
		Person person2 = new Person(123L, "Herbert", "Herder");
		assertFalse(person1.equals(person2));
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Person.Person#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Person person1 = new Person(234564L, "Timo", "Schmelzer");
		assertTrue(person.equals(person1));
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#hashCode()}.
	 */
	@Test
	public void testHashCodeEqual() {
		Person person1 = new Person(234564L, "Timo", "Schmelzer");
		if (person.equals(person1)) {
			assertEquals(person.hashCode(), person1.hashCode());
		}
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#hashCode()}.
	 */
	@Test
	public void testHashCodeNotEqual() {
		Person person1 = new Person(234L, "Timo", "Schmelzer");
		if (!person.equals(person1)) {
			assertNotEquals(person.hashCode(), person1.hashCode());
		}
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#hashCode()}.
	 */
	@Test
	public void testHashCodeMultiple() {
		final Person person1 = new Person(234564L, "Timo", "Schmelzer");
		assertArrayEquals(new int[] { person.hashCode(), person.hashCode(), person.hashCode() },
				new int[] { person1.hashCode(), person1.hashCode(), person1.hashCode() });
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#compareTo(ch.hslu.oop.sw07.Person.Person)}.
	 */
	@Test
	public  void testCompareToEqual(){
	assertTrue(person.compareTo(new Person(234564L, "Barbara", "Held")) == 0);
	}
	
	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#compareTo(ch.hslu.oop.sw07.Person.Person)}.
	 */
	@Test
	public  void testCompareToBigger(){
	assertTrue(person.compareTo(new Person(234563L, "Barbara", "Held")) > 0 );
	}
	
	/**
	 * Test method for {@link ch.hslu.oop.sw07.Person.Person#compareTo(ch.hslu.oop.sw07.Person.Person)}.
	 */
	@Test
	public  void testCompareToSmaller(){
	assertTrue(person.compareTo(new Person(234565L, "Barbara", "Held")) < 0);
	}

}
