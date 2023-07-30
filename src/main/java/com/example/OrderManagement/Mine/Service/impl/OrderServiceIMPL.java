package com.example.OrderManagement.Mine.Service.impl;

import com.example.OrderManagement.Mine.Service.OrderService;
import com.example.OrderManagement.Mine.dto.request.RequestOrderSaveDTO;
import com.example.OrderManagement.Mine.entity.Order;
import com.example.OrderManagement.Mine.entity.OrderDetails;
import com.example.OrderManagement.Mine.repo.CustomerRepo;
import com.example.OrderManagement.Mine.repo.ItemRepo;
import com.example.OrderManagement.Mine.repo.OrderDetailsRepo;
import com.example.OrderManagement.Mine.repo.OrderRepo;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getType;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO){
        Order order = new Order(
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal(),
                customerRepo.getById(requestOrderSaveDTO.getCustomers())
        );

        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderID())){
            List<OrderDetails> orderDetails = new ArrayList<>();

            orderDetails = modelMapper.map(requestOrderSaveDTO.getOrderDetails(), TypeToken<List<OrderDetails>>(){}
            .getType());

            for(int i=0; i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;


    }
}
