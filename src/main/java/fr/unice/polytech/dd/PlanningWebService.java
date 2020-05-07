package fr.unice.polytech.dd;

import fr.unice.polytech.isa.dd.exceptions.PackageAlreadyTookException;
import fr.unice.polytech.isa.dd.exceptions.UnvailableSlotTimeException;
import fr.unice.polytech.isa.dd.exceptions.UnknownCustomerException;
import fr.unice.polytech.isa.dd.exceptions.UnknownPackageException;
import fr.unice.polytech.isa.dd.interceptors.dateinterceptors.DateVerifierForRegister;
import fr.unice.polytech.isa.dd.interceptors.dateinterceptors.DateVerifierForReschedule;
import fr.unice.polytech.isa.dd.interceptors.dateinterceptors.DateVerifierForValidSlot;
import fr.unice.polytech.isa.dd.interceptors.hourinterceptors.HourVerifierForRegister;
import fr.unice.polytech.isa.dd.interceptors.hourinterceptors.HourVerifierForValidSlot;
import fr.unice.polytech.isa.dd.interceptors.hourinterceptors.HourVerifierReschedule;

import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/planningService")
public interface PlanningWebService {

    @WebMethod
    @WebResult(name="register_delivery")
    @Interceptors({DateVerifierForRegister.class, HourVerifierForRegister.class})
    String register_delivery(@WebParam(name="name_client") String nameClient,
                             @WebParam(name="number_secret") String numberSecret,
                             @WebParam(name="delivery_date") String deliveryDate,
                             @WebParam(name="hour_delivery") String hourDelivery) throws PackageAlreadyTookException, UnvailableSlotTimeException, UnknownCustomerException, UnknownPackageException, java.text.ParseException;

    @WebMethod
    @WebResult(name="repogramming_delivery")
    @Interceptors({DateVerifierForReschedule.class, HourVerifierReschedule.class})
    String repogramming_delivery(@WebParam(name="old_date") String oldDate,
                             @WebParam(name="old_hour") String oldHour,
                             @WebParam(name="delivery_date") String deliveryDate,
                             @WebParam(name="hour_delivery") String hourDelivery) throws UnvailableSlotTimeException, java.text.ParseException;

    @WebMethod
    @WebResult(name = "valid_slot")
    @Interceptors({DateVerifierForValidSlot.class, HourVerifierForValidSlot.class})
    Boolean validSlot(@WebParam(name="delivery_date") String deliveryDate,
                      @WebParam(name="hour_delivery") String hourDelivery) throws java.text.ParseException;
}
