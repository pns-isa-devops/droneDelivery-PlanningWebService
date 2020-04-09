package fr.unice.polytech.dd;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/planningService")
public interface PlanningWebService {

    @WebMethod
    @WebResult(name="register_delivery")
    void register_delivery(String name_client, String name_provider);
}
