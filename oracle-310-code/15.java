package org.kodejava.example.commons.lang;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class DummyUser {
    private Long id;
    private String name;

    /**
     * Constructor to create an instance of this class.
     */
    public DummyUser() {
    }

    public static void main(String[] args) {
        DummyUser user1 = new DummyUser();
        user1.setId(10L);
        user1.setName("Carol");

        DummyUser user2 = new DummyUser();
        user2.setId(10L);
        user2.setName("Carol");

        System.out.println("user1.hashCode() = " + user1.hashCode());
        System.out.println("user2.hashCode() = " + user2.hashCode());

        System.out.println("user1.equals(user2) = " + user1.equals(user2));
    }

    //
    // Getters & Setters
    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Implement the hashCode method using HashCodeBuilder.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).toHashCode();
    }

    /**
     * Implement the equals method using the EqualsBuilder.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DummyUser)) {
            return false;
        }
        DummyUser that = (DummyUser) obj;
        return new EqualsBuilder().append(this.id, that.id)
                .append(this.name, that.name).isEquals();
    }
}