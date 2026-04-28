package ucr.algoritmos.pg03algoritmos.model;

public class Employee extends Person{

    private String jobPosition;

    public Employee(String name, String id, int age, double height, double weight, String jobPosition) {
        super(name, id, age, height, weight);
        this.jobPosition = jobPosition;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public String getRoleDescription() {
        return "Empleado: " + getName() + " puesto " + jobPosition;
    }
    @Override
    public String toString() {
        return  super.toString() + "\n " + getRoleDescription();
    }
}
