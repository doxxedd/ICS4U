package OOP;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) { 
        super(name, address);
        this.program = program; 
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() { return this.program; }
    public void setProgram() { this.program = program; }
    public int getYear() { return this.year; }
    public void setYear() { this.year = year; }
    public double getFee() { return this.fee; }
    public void setFee() { this.fee = fee; } 
    public String toString() { return "Student [Person[name =  " + getName() + " ,address = " 
    + getAddress() + " ,program = " + this.program + " ,year = " + this.year + " ,fee = " + this.fee; }
}
