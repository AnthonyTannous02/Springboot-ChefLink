package com.SoftwareEngineeringProject.demo.dao;

import org.springframework.stereotype.Service;

import com.SoftwareEngineeringProject.demo.entity.Customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDAO customerRepository;

    public CustomerService(CustomerDAO customerRepository) {
        this.customerRepository = customerRepository;
    }

    @SuppressWarnings("null")
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}