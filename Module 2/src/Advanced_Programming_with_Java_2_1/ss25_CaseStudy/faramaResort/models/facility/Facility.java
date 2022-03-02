package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility;

public abstract class Facility {
    private String idService;
    private String serviceName;
    private double areaUsable;
    private int rent;
    private int maxPeople;
    private String rentType;

    public Facility() {
    }

    public Facility(String idService, String serviceName, double areaUsable, int rent, int maxPeople, String rentType) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.areaUsable = areaUsable;
        this.rent = rent;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUsable() {
        return areaUsable;
    }

    public void setAreaUsable(double areaUsable) {
        this.areaUsable = areaUsable;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "idService='" + idService + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaUsable=" + areaUsable +
                ", rent=" + rent +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' ;

    }

}
