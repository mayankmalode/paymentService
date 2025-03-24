package designpatters;

public class Builder {
    private String name;
    private int age;
    private int psp;
    private String batch;
    private int gradYear;
    private String univName;
    private int rollNo;

    public String getName() {
        return name;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public int getPsp() {
        return psp;
    }

    public Builder setPsp(int psp) {
        this.psp = psp;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public Builder setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public int getGradYear() {
        return gradYear;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }

    public String getUnivName() {
        return univName;
    }

    public Builder setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    public int getRollNo() {
        return rollNo;
    }

    public Builder setRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public Student build() {
        //validations start
        if(this.getAge() < 20)
            throw new IllegalArgumentException("Age must be greater than 20");

        if(this.getGradYear() >= 2023)
            throw new RuntimeException("Grad year must be less than or equal to 2023");
        //validations end

        return new Student(this);
    }
}
