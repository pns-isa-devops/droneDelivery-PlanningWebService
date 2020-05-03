package fr.unice.polytech.dd;


import fr.unice.polytech.isa.dd.AvailableSlotTime;
import fr.unice.polytech.isa.dd.DeliveryRegistration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/planningService")
@Stateless(name = "PlanningWS")
public class PlanningWebServiceImpl implements PlanningWebService {

    @EJB(name = "planning-stateless")
    private DeliveryRegistration deliveryRegistration;
    @EJB(name = "planning-stateless")
    private AvailableSlotTime availableSlotTime;


    @Override
    public String register_delivery(String nameClient, String numberSecret, String deliveryDate, String hourDelivery) throws Exception {
        System.out.println("Enregistrement d'une nouvelle livraison");
        return deliveryRegistration.register_delivery(nameClient,numberSecret,deliveryDate,hourDelivery);
    }

    @Override
    public Boolean validSlot(String deliveryDate, String hourDelivery) throws Exception {
        System.out.println("Validation d'un horaire");
        return  availableSlotTime.valid_slot_time(deliveryDate,hourDelivery);
    }

    @Override
    public  String repogramming_delivery(String oldDate,String oldHour, String deliveryDate, String hourDelivery) throws Exception {
        System.out.println("Reprogrammation d'un horaire");
        return deliveryRegistration.repogramming_delivery(oldDate,oldHour,deliveryDate,hourDelivery);
    }
}