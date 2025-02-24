package org.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    @org.junit.jupiter.api.Test
    void findByName_CorrectNameFormat_Correct() {
        PersonsList myList= new PersonsList();
        Person myPerson1 = new Person (1234,"John Hood", 34, "Policeman");
        Person myPerson2 = new Person (4536, "Anais Nin", 66, "writer");
        Person myPerson3 = new Person (7489,"Marry Kain", 54,"waiter");

        myList.addPerson(myPerson1);
        myList.addPerson(myPerson2);
        myList.addPerson(myPerson3);

        assertEquals(myPerson2, myList.findByName("Anais Nin"));
    }

    @org.junit.jupiter.api.Test
    void findByName_IncorrectNameFormat_Error() {
        PersonsList myList= new PersonsList();
        Person myPerson1 = new Person (1234,"John Hood", 34, "Policeman");
        Person myPerson2 = new Person (4536, "Anais Nin", 66, "writer");
        Person myPerson3 = new Person (7489,"Marry Kain", 54,"waiter");

        myList.addPerson(myPerson1);
        myList.addPerson(myPerson2);
        myList.addPerson(myPerson3);

        assertThrows(CorrectName.class, () -> {
            myList.findByName("Anais");
        });
    }

    @org.junit.jupiter.api.Test
    void testClone_InstancePerson_Correct() {
        PersonsList myList= new PersonsList();
        Person myPerson1 = new Person (1234,"John Hood", 34, "Policeman");
        Person myPerson2 = new Person (4536, "Anais Nin", 66, "writer");
        Person myPerson3 = new Person (7489,"Marry Kain", 54,"waiter");

        myList.addPerson(myPerson1);
        myList.addPerson(myPerson2);
        myList.addPerson(myPerson3);


        assertTrue(myPerson3.equals(new Person (7489,"Marry Kain", 54,"waiter")) &&
                myPerson3.getId()!=myList.clone(myPerson3).getId());

    }
}