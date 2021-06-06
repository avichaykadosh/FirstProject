import java.util.Objects;

public class HourlyEmployee extends Employee{
    private int hours;
    private float wage;

    public HourlyEmployee(String firstName, String lastName, int id, int hours, float wage) {
        super(firstName, lastName, id);
        try {
            setHours(hours);
            setWage(wage );
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public HourlyEmployee() {
        try {
            setHours(0);
            setWage(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws Exception {
        if (hours<= 0 ){
            throw new Exception("hours is negative");
        }
        this.hours = hours;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public double earnings() {
        return getHours() * getWage();
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", hours=" + hours +
                ", wage=" + wage +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return hours == that.hours && Float.compare(that.wage, wage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hours, wage);
    }
}
