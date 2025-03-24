package designpatters;

public class Client {
    public static void main(String[] args) {
        Builder builder = Student.getBuilder();
        builder.setName("Mayank");
        builder.setAge(25);
        builder.setGradYear(2021);

        Student student = builder.build();

    }
}
