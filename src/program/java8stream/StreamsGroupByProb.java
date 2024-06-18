package program.java8stream;

import java.util.*;
import java.util.stream.Collectors;

class StreamsGroupByProb {
    static List<Employee> employeeList
            = Arrays.asList(new Employee("Tom Jones", 45, 15000.00, "Dev"),
            new Employee("Tom Jones", 45, 7000.00, "Dev"),
            new Employee("Ethan Hardy", 65, 8000.00, "QA"),
            new Employee("Nancy Smith", 22, 10000.00, "QA"),
            new Employee("Deborah Sprightly", 29, 9000.00, "GS"));

    public static void main(String[] args) {
        /* Comparator<Employee> c=(o1,o2)->o1.getSalary -o2.getSalary; */

        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(i -> System.out.println(i));

        Optional<Employee> maxSalaryEmp =
                employeeList.stream()
                        .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Employee with max salary:"
                + (maxSalaryEmp.isPresent() ? maxSalaryEmp.get() : "Not Applicable"));

        Optional<Employee> minAgeEmp =
                employeeList.stream()
                        .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("Employee with min age:"
                + (minAgeEmp.isPresent() ? minAgeEmp.get() : "Not Applicable"));


        Double salSum = employeeList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("sum of All Salary----->" + salSum);


        Map<String, Double> deptSalSum = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

        System.out.println("Sum of Salary from Each Dept---->" + deptSalSum);


        Map<String, Double> avgSalaryOfDepartments = employeeList.stream().
                collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average Salary from each Dept----->" + avgSalaryOfDepartments);

        //avgSalaryOfDepartments.forEach((k, v) -> System.out.println(k + " " + v));

        Optional<Employee> e1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Highest Salaried Employee------->" + (e1.isPresent() ? e1.get() : "no value"));

        Map<String, Optional<Employee>> maxSalDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, (Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
        System.out.println("Max salary from each Dept------>" + maxSalDept);

        Map<String, List<Employee>> mp1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, (Collectors.toList())));
        System.out.println("Employees group by dept-------->" + mp1);

        List<Employee> l1 = employeeList.stream().sorted((Comparator.comparingDouble(Employee::getSalary).reversed())).collect(Collectors.toList());
        System.out.println("List sorted based on salary descending------->" + l1);

    }
}
