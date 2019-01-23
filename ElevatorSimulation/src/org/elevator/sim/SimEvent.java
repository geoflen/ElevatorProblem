package org.elevator.sim;

public class SimEvent 
{
    public double time;
    public int id;
    public TOKEN token;
    public int priority;
    
    public SimEvent() {
        token = new TOKEN();
    }
}