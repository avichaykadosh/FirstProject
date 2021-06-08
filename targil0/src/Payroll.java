public class Payroll {
    public static void main(String[] args){
        HourlyEmployee firstEmployee = new HourlyEmployee("Avihay", "Kadosh",316243070,25,32);
        CommissionEmployee secondEmployee = new CommissionEmployee("Beni","Bruchim",456,750,15);
        BasePlusCommissionEmployee thirdemployee = new BasePlusCommissionEmployee("Gadi","gur",789,1000,18,3500);

        Employee[] arr = new Employee[3];

        arr[0] = firstEmployee;
        arr[1] = secondEmployee;
        arr[2] = thirdemployee;

        for (int i = 0; i < 3; i++) {
//            System.out.println(arr[i]);
        }
    }
}
// Avihay Kadosh
// id - 316243070