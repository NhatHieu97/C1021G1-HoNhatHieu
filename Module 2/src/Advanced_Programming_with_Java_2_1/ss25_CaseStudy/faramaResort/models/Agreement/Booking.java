package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.Agreement;

import java.util.Date;

public class Booking implements Comparable<Booking> {
    private String idContract;
    private String beginDay;
    private String endDate;
    private String idCustomer;
    private String nameService;
    private String serviceType;

    public Booking(String idContract, String beginDay, String endDate, String idCustomer, String nameService, String serviceType) {
        this.idContract = idContract;
        this.beginDay = beginDay;
        this.endDate = endDate;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.serviceType = serviceType;
    }

    public Booking() {
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(String beginDay) {
        this.beginDay = beginDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idContract='" + idContract + '\'' +
                ", beginDay='" + beginDay + '\'' +
                ", endDate='" + endDate + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        String thisBeginDay = this.getBeginDay();
        String otherBeginDay = o.getBeginDay();
        String thisEndDate = this.getEndDate();
        String otherEndDate = o.getEndDate();
        String[] thisBenginDayArr = thisBeginDay.split("/");
        String[] otherBenginDayArr = otherBeginDay.split("/");
        String[] thisEndDateArr = thisEndDate.split("/");
        String[] otherEndDateArr = otherEndDate.split("/");
        long thisBeginToMilli = new Date(Integer.parseInt(thisBenginDayArr[2]), Integer.parseInt(thisBenginDayArr[1]), Integer.parseInt(thisBenginDayArr[0])).getTime();
        long otherbeginToMilli = new Date(Integer.parseInt(otherBenginDayArr[2]), Integer.parseInt(otherBenginDayArr[1]), Integer.parseInt(otherBenginDayArr[0])).getTime();
        long thisEndToMilli = new Date(Integer.parseInt(thisEndDateArr[2]), Integer.parseInt(thisEndDateArr[1]), Integer.parseInt(thisEndDateArr[0])).getTime();
        long otherEndToMilli = new Date(Integer.parseInt(otherEndDateArr[2]), Integer.parseInt(otherEndDateArr[1]), Integer.parseInt(otherEndDateArr[0])).getTime();
        if ((thisBeginToMilli - otherbeginToMilli) != 0){
            return (thisBeginToMilli - otherbeginToMilli) < 0 ? -1 : 1;
        }else {
            if ((thisEndToMilli - otherEndToMilli) < 0){
                return -1;
            }else if ((thisEndToMilli - otherEndToMilli) > 0){
                return 1;
            }else {
                return 0;
            }
        }

    }
}
