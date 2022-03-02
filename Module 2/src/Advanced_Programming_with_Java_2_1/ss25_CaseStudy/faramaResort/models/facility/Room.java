package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility;

import java.util.Objects;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String idService ,String serviceName, double areaUsable, int rent, int maxPeople, String rentType, String freeService) {
        super(idService, serviceName, areaUsable, rent, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room {" +
                super.toString()+
                ",freeService'" + freeService +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(this.getServiceName(), room.getServiceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getServiceName());
    }
}
