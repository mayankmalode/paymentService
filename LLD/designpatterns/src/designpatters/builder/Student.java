package designpatters;

public class Student {
    private String name;
    private int age;
    private int psp;
    private String batch;
    private int gradYear;
    private String univName;
    private int rollNo;

    public Student(Builder builder) {
        this.age = builder.getAge();
        this.psp = builder.getPsp();
        this.batch = builder.getBatch();
        this.gradYear = builder.getGradYear();
        this.univName = builder.getUnivName();
        this.rollNo = builder.getRollNo();

    }
    public static Builder getBuilder(){
        return new Builder();
    }
}

