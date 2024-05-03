package co.simplon.gael.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="firestations")
public class Firestation {
    @Id
    @Column(name="address")
    private String address;
    @Column(name="station")
    private String station;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }
    public Firestation() {
    }
    @Override
    public String toString() {
	return "{address=" + address + ", station=" + station + "}";
    }
    
    
}
