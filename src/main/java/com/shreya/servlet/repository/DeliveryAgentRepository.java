package com.shreya.servlet.repository;
import  com.shreya.servlet.model.DeliveryAgent;
import java.util.HashSet;
import java.util.Set;

public class DeliveryAgentRepository {
    Set<DeliveryAgent> deliveryAgents = new HashSet<>();

    public void createDeliveryAgent(DeliveryAgent deliveryAgent){
        deliveryAgents.add(deliveryAgent);
    }
    public void displayDeliveryAgent(DeliveryAgent deliveryAgent){
        deliveryAgents.remove(deliveryAgent);
    }
    public void displayDeliveryAgentToBeClosed(int id){

        DeliveryAgent deliveryAgentToBeClosed = null;
        for(DeliveryAgent deliveryAgent : deliveryAgents){
           if (deliveryAgent.getId() == id){
               deliveryAgentToBeClosed = deliveryAgent;
           }
        }
       deliveryAgents.remove(deliveryAgentToBeClosed);
    }

}
