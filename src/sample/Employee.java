package sample;

import java.util.UUID;

public class Employee implements Worker{
    public String firstName;
    public String LastName;
    public boolean isActive;
    // UUID Universal unique Identifier, String 100 20 bit unique string globally
    public UUID id;

    public Employee(){
        //whenever a new employee created, it will give a unique id to employee
        this.id = UUID.randomUUID();
    }
    @Override
    public String toString()
    {
        //This dot represent the current class and after this the parameter
        return this.firstName + " " + this.LastName;
    }

    @Override
    public void hire()
    {
        isActive = true;
    }

    @Override
    public void fire()
    {
        isActive = false;
    }
}
