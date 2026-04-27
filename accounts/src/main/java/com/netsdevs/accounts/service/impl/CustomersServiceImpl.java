package com.netsdevs.accounts.service.impl;

import com.netsdevs.accounts.dto.AccountsDto;
import com.netsdevs.accounts.dto.CardsDto;
import com.netsdevs.accounts.dto.CustomerDetailsDto;
import com.netsdevs.accounts.dto.LoansDto;
import com.netsdevs.accounts.entity.Accounts;
import com.netsdevs.accounts.entity.Customer;
import com.netsdevs.accounts.exception.ResourceNotFoundException;
import com.netsdevs.accounts.mapper.AccountsMapper;
import com.netsdevs.accounts.mapper.CustomerMapper;
import com.netsdevs.accounts.repository.AccountsRepository;
import com.netsdevs.accounts.repository.CustomerRepository;
import com.netsdevs.accounts.service.ICustomersService;
import com.netsdevs.accounts.service.client.CardsFeignClient;
import com.netsdevs.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     *  @param correlationId - Correlation ID value generated at Edge server
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(null != loansDtoResponseEntity) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }


        return customerDetailsDto;

    }
}
