package model.person;

public class Customer extends Person {
    private Boolean gender;
    private String customerType;
    private int idCustomerType;

    public Customer() {
    }

    public Customer(Boolean gender, String customerType, int idCustomerType) {
        this.gender = gender;
        this.customerType = customerType;
        this.idCustomerType = idCustomerType;
    }

    public Customer(int id, String name, String birthday, String idCard, String phone, String email, String address, String code, Boolean gender, String customerType, int idCustomerType) {
        super(id, name, birthday, idCard, phone, email, address, code);
        this.gender = gender;
        this.customerType = customerType;
        this.idCustomerType = idCustomerType;
    }


    public Customer(int id, String name, String birthday, String idCard, String phone, String email, String address, String code, Boolean gender) {
        super(id, name, birthday, idCard, phone, email, address, code);
        this.gender = gender;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }
}
