import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private float baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision, float baseSalary) {
        super(firstName, lastName, id, grossSales, commision);
        try {
            setBaseSalary(baseSalary);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }    }

    public BasePlusCommissionEmployee(float grossSales, int commision, float baseSalary) {
        super(grossSales, commision);
        try {
            setBaseSalary(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) throws Exception {
        if (baseSalary<= 0 ){
            throw new Exception("salary is negative");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "baseSalary=" + baseSalary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;
        return Float.compare(that.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public double earnings() {
        return baseSalary + commision / 100 * grossSales;
    }
}
