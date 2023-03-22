package entities;

public class TaxPayer {

    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;


    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome,double healthSpending, double educationSpending ){
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        double salary = salaryIncome / 12;
        double tax;

        if (salary < 3000) {
            tax = 0.0;
        } else if (salary < 5000) {
            tax = 0.1;
        } else {
            tax = 0.2;
        }
        return salaryIncome * tax;
    }

    public double servicesTax() {
        double services = servicesIncome;
        double tax;
        if (services > 0) {
            tax = 0.15;
        } else {
            tax = 0.0;
        }
        return servicesIncome * tax;
    }
    public double capitalTax() {
        double capital = capitalIncome;
        double tax;
        if (capital > 0) {
            tax = 0.2;
        } else {
            tax = 0.0;
        }
        return capitalIncome * tax;
    }
    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }
    public double taxRebate() {
        double rebateGrossTax = grossTax() * 0.3;
        double medicalEducationalExpenses = healthSpending + educationSpending;

        if (medicalEducationalExpenses < rebateGrossTax ) {
            return  medicalEducationalExpenses;
        } else {
            return rebateGrossTax;
        }
    }
    public double netTax() {
        return grossTax() - taxRebate();
    }


}
