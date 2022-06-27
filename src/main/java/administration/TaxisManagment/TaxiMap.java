package administration.TaxisManagment;

import SmartCity.Position;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.UUID;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaxiMap {

    private HashMap<UUID,TaxiInfo> TaxiMap;

    private static TaxiMap istance;

    private TaxiMap(){
        TaxiMap = new HashMap<>();
    }

    public synchronized static TaxiMap getInstance(){
        if(istance == null)
            istance = new TaxiMap();
        return istance;
    }
    public synchronized HashMap<UUID,TaxiInfo> getTaxiesMap(){
        return new HashMap<>(TaxiMap);
    }

    public synchronized void addTaxi(UUID id, String ip, int port, Position position){
        TaxiMap.put(id,new TaxiInfo(ip,port,position));
    }

    public TaxiInfo getInfoById(UUID id){
        HashMap<UUID,TaxiInfo> taxiesCopy = getTaxiesMap();
        return taxiesCopy.get(id);
    }

    public synchronized void removeTaxi(UUID id) {
        TaxiMap.remove(id);
    }
}
