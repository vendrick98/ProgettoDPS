package administration.services;

import SmartCity.MapHelper;
import administration.TaxisManagment.TaxiInfo;
import administration.TaxisManagment.TaxiMap;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.UUID;

@Path("taxi")
public class TaxiServices {

    @GET
    @Produces({"application/json", "application/xml"})
    public Response getTaxiList(){
        return Response.ok(TaxiMap.getInstance()).build();
    }

    //permette di inserire un taxi
    @Path("add")
    @POST
    @Consumes({"application/json", "application/xml"})
    public Response addTaxi(UUID id,String ip,int port){
        TaxiMap taxiesistance = TaxiMap.getInstance();
        HashMap<UUID, TaxiInfo> taxies = taxiesistance.getTaxiesMap();
        if(!taxies.containsKey(id)){
        taxiesistance.addTaxi(id, ip, port, MapHelper.getRandomRechargeStation());
        return Response.ok().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //permette di eleminare un taxi dato id
    @Path("remove")
    @POST
    @Consumes({"application/json", "application/xml"})
    public Response removeTaxi(UUID id){
        if(TaxiMap.getInstance().getTaxiesMap().containsKey(id)) {
            TaxiMap.getInstance().removeTaxi(id);
            return Response.ok().build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
    @POST
    @Path("/sendStats")
    @Consumes({"application/json", "application/xml"})
    public Response sendStats(String stats) {
        //TODO
        return Response.ok().build();
    }
}
