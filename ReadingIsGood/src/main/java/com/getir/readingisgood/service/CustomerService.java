package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.UserDTO;
import com.getir.readingisgood.model.CustomerOrderRequest;
import com.getir.readingisgood.model.CustomerOrderResponse;
import com.getir.readingisgood.entity.User;
import com.getir.readingisgood.entity.Orders;
import com.getir.readingisgood.exception.CustomerAlreadyRegisteredException;
import com.getir.readingisgood.exception.CustomerNotFoundException;
import com.getir.readingisgood.model.ResponseHeader;
import com.getir.readingisgood.repository.UserRepository;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public User getCustomerById(Long id) {
        User customer = userRepository.findById(id).
                orElseThrow(() -> new CustomerNotFoundException("Customer not found."));
        return customer;
    }

    public CustomerOrderResponse getCustomerOrders(CustomerOrderRequest customerOrderRequest) {
        User customer = getCustomerById(customerOrderRequest.getCustomerId());
        //PageRequest pageRequest = PageRequest.of(customerOrderRequest.getSize(),customerOrderRequest.getPage());
        List<Orders> orderPage = orderRepository.findAllByCustomer(customer);
        return new CustomerOrderResponse(new ResponseHeader(), customer.getId(),orderPage);
    }

    public UserDTO registerCustomer(UserDTO userDTO) {
        /*if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new CustomerAlreadyRegisteredException("There is already registered customer with this email, please try another one");
        }
        String password = Base64.encodeBase64String(DigestUtils.sha1(userDTO.getPassword()));
        User customer = User.builder().email(userDTO.getEmail())
                .password(password).build();
        return mapperUtil.convert(userRepository.save(customer),new UserDTO());*/
        return null;
    }
}
