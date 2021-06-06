import java.util.Objects;

public class CommissionEmployee extends Employee{

    protected float grossSales;
    protected int commision;


    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision) {
        super(firstName, lastName, id);

        try {
            setGrossSales(grossSales);
            setCommision(commision);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public CommissionEmployee(float grossSales, int commision) {
        try {
            setGrossSales(0);
            setCommision(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public float getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(float grossSales) throws Exception {
        if (grossSales <=0){
            throw new Exception("sales cannot be 0");
        }
        this.grossSales = grossSales;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) throws Exception {
        if (commision <=0){
            throw new Exception("comission cannot be 0");
        }
        this.commision = commision;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "grossSales=" + grossSales +
                ", commision=" + commision +
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
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(that.grossSales, grossSales) == 0 && commision == that.commision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grossSales, commision);
    }

    @Override
    public double earnings() {
        return commision / 100 * grossSales;
    }
}
