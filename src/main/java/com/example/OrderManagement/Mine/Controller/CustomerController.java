package com.example.OrderManagement.Mine.Controller;

import com.example.OrderManagement.Mine.Service.CustomerService;
import com.example.OrderManagement.Mine.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path="/save")
    public String SaveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return "Saved";
    }
    @PostMapping(path="/update")
    public String UpdateCustomer(@RequestBody CustomerDTO customerDTO){
        String updated = customerService.updateCustomer(customerDTO);
        return "Saved";
    }

    @GetMapping(path="/get-by-id",params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id")int customerId){
    CustomerDTO customerDTO = customerService.getCustomerByID(customerId);
    return customerDTO;
    }

    @GetMapping(path="/get-all-customes")
    public List<CustomerDTO> allCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int customerID) {
        String deleteCustomer = customerService.deleteCustomer(customerID);
        return deleteCustomer;
    }

}

