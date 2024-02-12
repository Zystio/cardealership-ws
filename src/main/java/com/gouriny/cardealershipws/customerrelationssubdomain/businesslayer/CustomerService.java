package com.gouriny.cardealershipws.customerrelationssubdomain.businesslayer;


import com.gouriny.cardealershipws.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import com.gouriny.cardealershipws.customerrelationssubdomain.presentationlayer.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseModel> getCustomers();

    CustomerResponseModel getCustomerByCustomerId(String customerId);

    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);

    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);

    void removeCustomer(String customerId);
}
