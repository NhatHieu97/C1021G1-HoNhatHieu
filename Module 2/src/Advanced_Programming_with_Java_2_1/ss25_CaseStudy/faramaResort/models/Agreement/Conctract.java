package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.Agreement;

public class Conctract {
    private String idContract;
    private String idBooking;
    private double deposit;
    private double total;
    private String idCustomer;

    public Conctract() {
    }

    public Conctract(String idContract, String idBooking, double deposit, double total, String idCustomer) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.total = total;
        this.idCustomer = idCustomer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Conctract{" +
                "idContract='" + idContract + '\'' +
                ", idBooking='" + idBooking + '\'' +
                ", deposit=" + deposit +
                ", total=" + total +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }
}
