package sg.edu.nus.iss.demoDay1a.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
//to get person constructor w no args
@NoArgsConstructor
//data annotation help us handle getter setter

//lombok only used in model (entity), controller is entry point, logic in service

public class Person {

    private String id;
    private String firstName;
    private String lastName;
    
    //use this constructor for create record
    public Person(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString().substring(0,8)/*dont type this, should auto generate(beginIndex:0, endIndex:8)*/;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //use this constructor for update records which are stored in service class right now, not connected to DB yet
    //service class call api class?
    public Person(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
