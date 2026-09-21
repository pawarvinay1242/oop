package oop;

import java.util.Scanner;

class EmployeeMain {
    String emp_Name;
    int emp_Id;
    String emp_address;
    String emp_MobileNo;
    String emp_EmailId;
    double basicPay; 

    // Constructor
    EmployeeMain(String emp_Name, int emp_Id, String emp_address, String emp_MobileNo, String emp_EmailId, double basicPay){
        this.emp_Name = emp_Name;
        this.emp_Id = emp_Id;
        this.emp_address = emp_address;
        this.emp_MobileNo = emp_MobileNo;
        this.emp_EmailId = emp_EmailId;
        this.basicPay = basicPay;
    }

    // Method to calculate and display salary details
    void generateSalarySlip(String Designation){
        double HRA = 0.10 * basicPay;
        double DA = 0.97 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClub = 0.001 * basicPay;
        double grossSalary = basicPay + HRA + DA;
        double totalDeductions = PF + staffClub;
        double TotalSalary = grossSalary - totalDeductions;

        System.out.println("================================Salary Slip for Employee==================================");
        System.out.println("Employee Name : " + emp_Name);
        System.out.println("Employee ID: " + emp_Id);
        System.out.println("Employee Address: " + emp_address);
        System.out.println("Employee Mobile No: " + emp_MobileNo);
        System.out.println("Employee Email ID: " + emp_EmailId);
        System.out.println("Designation: " + Designation);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("HRA: " + HRA);
        System.out.println("DA: " + DA);
        System.out.println("PF: " + PF);
        System.out.println("Staff Club: " + staffClub);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Total Salary: " + TotalSalary);
    }

    // Main execution method placed correctly inside the class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=================Employee Payroll System=================");
        System.out.println("Enter your choice: 1. Programmer 2. Team Lead 3. Assistant Project Manager 4. Project Manager");
        
        // Check if there is an integer to read before processing
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    Programmer programmer = new Programmer("John Doe", 101, "123 Main St", "5555-1234", "john.doe@example.com", 50000);
                    programmer.generateSalarySlip("Programmer");
                    break;

                case 2:
                    TeamLead teamLead = new TeamLead("Jane Smith", 102, "456 Oak Ave", "5555-5678", "jane.smith@example.com", 60000);
                    teamLead.generateSalarySlip("Team Lead");
                    break;

                case 3:
                    AssistantProjectManager assistantProjectManager = new AssistantProjectManager("Bob Johnson", 103, "789 Pine Rd", "5555-9012", "bob.johnson@example.com", 70000);
                    assistantProjectManager.generateSalarySlip("Assistant Project Manager");
                    break;

                case 4:
                    ProjectManager projectManager = new ProjectManager("Alice Williams", 104, "321 Elm St", "5555-3456", "alice.williams@example.com", 80000);
                    projectManager.generateSalarySlip("Project Manager");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } else {
            System.out.println("Please enter a valid numeric choice.");
        }
        sc.close();
    }
}

// Subclasses extending the corrected base class EmployeeMain
class Programmer extends EmployeeMain {
    Programmer(String emp_Name, int emp_Id, String emp_address, String emp_MobileNo, String emp_EmailId, double basicPay) {
        super(emp_Name, emp_Id, emp_address, emp_MobileNo, emp_EmailId, basicPay);
    }
}

class TeamLead extends EmployeeMain {
    TeamLead(String emp_Name, int emp_Id, String emp_address, String emp_MobileNo, String emp_EmailId, double basicPay) {
        super(emp_Name, emp_Id, emp_address, emp_MobileNo, emp_EmailId, basicPay);
    }
}

class AssistantProjectManager extends EmployeeMain {  
    AssistantProjectManager(String emp_Name, int emp_Id, String emp_address, String emp_MobileNo, String emp_EmailId, double basicPay) {
        super(emp_Name, emp_Id, emp_address, emp_MobileNo, emp_EmailId, basicPay);
    }
}

class ProjectManager extends EmployeeMain {
    ProjectManager(String emp_Name, int emp_Id, String emp_address, String emp_MobileNo, String emp_EmailId, double basicPay) {
        super(emp_Name, emp_Id, emp_address, emp_MobileNo, emp_EmailId, basicPay);
    }
}
