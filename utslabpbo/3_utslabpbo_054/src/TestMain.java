public class TestMain {
    public static void main(String[] args) {
        // Test constructor and toString()
        Employee e1 = new Employee(8, "Xavier", "Valave", 2500);
        System.out.println(e1); // toString();
        // Test Setters and Getters 
        e1.setSalary(999);
        System.out.println(e1); // toString();
        System.out.println("id is: " + e1.getID());
        System.out.println("firstname is: " + e1.getFirstName());
        System.out.println("lastname is: " + e1.getLastName());
        System.out.println("salary is: " + e1.getSalary());
        System.out.println("name is: " + e1.getName());
        System.out.println("annual salary is: " + e1.getAnnualSalary()); //Test method
        // Test raiseSalary()
        System.out.println(e1.raiseSalary(10));
        System.out.println(e1);
    } 

}

class Employee {
    // Atribut
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    // Constructor
    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Method untuk mendapatkan ID karyawan
    public int getID() {
        return id;
    }

    // Method untuk mendapatkan nama depan karyawan
    public String getFirstName() {
        return firstName;
    }

    // Method untuk mendapatkan nama belakang karyawan
    public String getLastName() {
        return lastName;
    }

    // Method untuk mendapatkan nama lengkap karyawan
    public String getName() {
        return firstName + " " + lastName;
    }

    // Method untuk mendapatkan gaji karyawan
    public int getSalary() {
        return salary;
    }

    // Method untuk mengatur gaji karyawan
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Method untuk mendapatkan gaji tahunan karyawan
    public int getAnnualSalary() {
        return salary * 12;
    }

    // Method untuk menaikkan gaji karyawan sebesar persentase tertentu
    public int raiseSalary(int percent) {
        double raiseAmount = salary * ((double) percent / 100.0);
        salary += raiseAmount;
        return salary;
    }

    // Method untuk menampilkan informasi karyawan dalam bentuk String
    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + getName() + ", salary=" + salary + "]";
    }
}
