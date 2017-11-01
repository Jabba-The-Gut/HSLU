/**
 * 
 */
package ch.hslu.oop.sw07.Person;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Modellierung einer Person mit einer eindeutigen Identifikationsnummer
 * 
 * @author Daveeee
 *
 */
public class Person implements Comparable<Person> {
    private final long id;
    private String firstname;
    private String lastname;

    public Person(long id, String first, String last) {
            this.id = id;
            this.firstname = first;
            this.lastname = last;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    @Override
    public final String toString() {
        return "Person-Objekt mit Namen: " + this.firstname + " und Nachnamen: " + this.lastname + " und ID: "
                + this.id;
    }

    /**
     * Override of the Object .equals()-Method. Two Person-Objects are only equal,
     * if they're of the same type and have the same id.
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Person) {
            final Person person = (Person) obj;
            if (person.getId() == this.getId()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * As two Person-Objects are equal if their id is the same, the hash-Code is
     * generated using the ID. This ensures that two Person-Object with the same ID
     * have the same Hash-Code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.id, 100);
    }

    /**
     * Zwei Person-Objekte werden aufrung ihrer ID verglichen
     */
	@Override
	public final int compareTo(Person o) {
		return Long.compare(this.id, o.id);
	}
    
    
    
    
}
