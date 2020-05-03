package fr.unice.polytech.dd;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/planningService")
public interface PlanningWebService {

    @WebMethod
    @WebResult(name="register_delivery")
    String register_delivery(@WebParam(name="name_client") String nameClient,
                             @WebParam(name="number_secret") String numberSecret,
                             @WebParam(name="delivery_date") String deliveryDate,
                             @WebParam(name="hour_delivery") String hourDelivery) throws Exception;

    @WebMethod
    @WebResult(name="repogramming_delivery")
    String repogramming_delivery(@WebParam(name="old_date") String oldDate,
                             @WebParam(name="old_hour") String oldHour,
                             @WebParam(name="delivery_date") String deliveryDate,
                             @WebParam(name="hour_delivery") String hourDelivery) throws Exception;

    @WebMethod
    @WebResult(name = "valid_slot")
    Boolean validSlot(@WebParam(name="delivery_date") String deliveryDate,
                      @WebParam(name="hour_delivery") String hourDelivery) throws Exception;
}
