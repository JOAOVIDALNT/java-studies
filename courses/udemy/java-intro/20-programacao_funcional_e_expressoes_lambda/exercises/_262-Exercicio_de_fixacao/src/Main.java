import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the full file path: ");
        String path = sc.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> employeeList = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                employeeList.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Salary base: ");
            Double salaryBase = sc.nextDouble();

            System.out.print("Character to filter salary: ");
            Character filter = sc.next().charAt(0);

            List<String> emails = employeeList.stream()
                    .filter(x -> x.getSalary() > salaryBase)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            double sum = employeeList.stream()
                    .filter(x -> x.getName().charAt(0) == filter)
                    .map(x -> x.getSalary())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary of people that name starts with '" + filter + "': " + String.format("%.2f", sum));


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



        sc.close();
    }
}