package hello;

import org.springframework.data.annotation.Id;

/**
 * Created by xialei on 2017/3/1.
 */
public class Customer {

    @Id
    public String id;
    public String firstName;
    public String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
