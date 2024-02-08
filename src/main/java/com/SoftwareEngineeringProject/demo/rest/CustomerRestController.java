package com.SoftwareEngineeringProject.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.SoftwareEngineeringProject.demo.dao.CustomerDAO;
import com.SoftwareEngineeringProject.demo.dao.CustomerService;
import com.SoftwareEngineeringProject.demo.entity.Customer;

import jakarta.annotation.PostConstruct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerService customerService;
    private final CustomerDAO customerDAO;

    public CustomerRestController(CustomerService customerService, CustomerDAO customerDAO) {
        this.customerService = customerService;
        this.customerDAO = customerDAO;
    }

    private List<Customer> cust;

    @PostConstruct
    public void loadData() {
        cust = new ArrayList<>();
        cust.add(new Customer("John1", "1", "JohnDoe1@lau.edu", "+961823495", "Malee", "John1", "Doe1", "2/5/2002",
                "@3245324"));
        cust.add(new Customer("John2", "2", "JohnDoe2@lau.edu", "+96182395", "Maleee", "John2", "Doe2", "3/5/2002",
                "@324555"));
        cust.add(
                new Customer("John3", "3", "JohnDoe3@lau.edu", "+96182345", "Maleeee", "John3", "Doe3", "23/56/2002",
                        "@3245324"));
        cust.add(new Customer("John4", "4", "JohnDoe4@lau.edu", "+9618245", "Maleeeee", "John4", "Doe4",
                "23/566/2002",
                "@32453245555"));
        cust.add(new Customer("John5", "5", "JohnDoe5@lau.edu", "+961825", "Mal", "John5", "Doe5", "23/5/20022",
                "@32455555"));

    }

    @GetMapping("/Customer")
    public List<Customer> getCustomers() {
        return cust;
    }

    @GetMapping("/Customer/{UUID}") // Check how to retrieve the body using Spring boot
    public Customer getCustomer(@PathVariable String UUID) {
        return cust.get(Integer.parseInt(UUID));
    }

    @PutMapping("/Customer/Add") // Corrected endpoint check @PutMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getuUID());
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/Customer/GetAttrib")
    public ResponseEntity<String> getUserAttributes(@RequestBody JsonNode req) {
        // Create a custom JSON object
        Map<String, Object> response = new HashMap<>();

        response.put("username", req.get("attribs").getClass());

        Customer customer= new Customer();
        System.out.println(customerService.getAll());

        response.put("attribute1", "value1");
        response.put("attribute2", "value2");

        // Convert the custom JSON object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // Return the customized JSON response
        return ResponseEntity.ok(jsonResponse);
    }
}
