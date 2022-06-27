package administration.TaxisManagment;

import SmartCity.Position;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public class Taxi {

    private UUID id;
    private TaxiInfo info;

    public Taxi(UUID id,TaxiInfo info) {
        this.id = id;
        this.info = info;
    }
    public Taxi(UUID id, String ip, int port, Position pos){
        this.id = id;
        this.info = new TaxiInfo(ip,port,pos);
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setInfo(TaxiInfo info) {
        this.info = info;
    }

    public TaxiInfo getInfo() {
        return info;
    }
}
