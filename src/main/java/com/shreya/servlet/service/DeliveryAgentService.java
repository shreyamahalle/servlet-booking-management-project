package com.shreya.servlet.service;
import  com.shreya.servlet.model.DeliveryAgent;
import  com.shreya.servlet.repository.DeliveryAgentRepository;
import java.util.*;

public class DeliveryAgentService implements DeliveryAgentServiceInterface  {
    private DeliveryAgentRepository deliveryAgentRepository = new DeliveryAgentRepository();
    public static Map<Integer, DeliveryAgent> deliveryAgents = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    void printCustomer(DeliveryAgent deliveryAgent){

        System.out.println(deliveryAgent);
    }

    public DeliveryAgent createDeliveryAgent(){

        DeliveryAgent deliveryAgent = new DeliveryAgent();
        deliveryAgentRepository.createDeliveryAgent(deliveryAgent);
        deliveryAgentRepository.displayDeliveryAgent(deliveryAgent);
        deliveryAgentRepository.displayDeliveryAgentToBeClosed(1);
        try {

            System.out.println("Please enter id");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter name");
            String name = sc.nextLine();

            System.out.println("Please enter city");
            String city = sc.nextLine();

            System.out.println("Please enter mobileNo");
            int mobileNo = Integer.parseInt(sc.nextLine());

            deliveryAgent.setId(id);
            deliveryAgent.setName(name);
            deliveryAgent.setCity(city);
            deliveryAgent.setMobileNo(mobileNo);
            deliveryAgents.put(1, deliveryAgent);
        }catch (Exception e){
                System.out.println("Invalid input type correct data");
            }
        return deliveryAgent;
    }

    public void displayDeliveryAgent(){

        try {

//         Set<Map.Entry<Integer,DeliveryAgent>> entrySet = deliveryAgents.entrySet();
//         for(Map.Entry<Integer,DeliveryAgent>customerEntry : entrySet){
//            System.out.println("Customer Info: " + deliveryAgents );
//          }

            //java 8 features forEach loop..
            deliveryAgents.forEach((id, deliveryAgents)-> System.out.println("deliveryAgents Id " + id + " = deliveryAgents info " + deliveryAgents));

            }catch (Exception e){
            System.out.println("Invalid input type correct data");
        }
    }
}

