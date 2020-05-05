package fr.unice.polytech.dd;

import fr.unice.polytech.isa.dd.exceptions.PackageAlreadyTookException;
import fr.unice.polytech.isa.dd.exceptions.UnvailableSlotTimeException;
import fr.unice.polytech.isa.dd.exceptions.UnknownCustomerException;
import fr.unice.polytech.isa.dd.exceptions.UnknownPackageException;

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
                             @WebParam(name="hour_delivery") String hourDelivery) throws PackageAlreadyTookException, UnvailableSlotTimeException, UnknownCustomerException, UnknownPackageException, java.text.ParseException;

    @WebMethod
    @WebResult(name="repogramming_delivery")
    String repogramming_delivery(@WebParam(name="old_date") String oldDate,
                             @WebParam(name="old_hour") String oldHour,
                             @WebParam(name="delivery_date") String deliveryDate,
                             @WebParam(name="hour_delivery") String hourDelivery) throws UnvailableSlotTimeException, java.text.ParseException;

    @WebMethod
    @WebResult(name = "valid_slot")
    Boolean validSlot(@WebParam(name="delivery_date") String deliveryDate,
                      @WebParam(name="hour_delivery") String hourDelivery) throws java.text.ParseException;
}
