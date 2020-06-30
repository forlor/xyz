package org.xyz.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.xyz.mapstruct.dto.Customer;
import org.xyz.mapstruct.dto.CustomerDto;

@Mapper
public interface CustomerMapper extends CommonMapper<CustomerDto, Customer> {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);
    // Customer convert(CustomerDto customerDto);
}
