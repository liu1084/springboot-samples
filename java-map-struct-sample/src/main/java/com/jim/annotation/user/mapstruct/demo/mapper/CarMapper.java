package com.jim.annotation.user.mapstruct.demo.mapper;
import com.jim.annotation.user.mapstruct.demo.entity.Car;
import com.jim.annotation.user.mapstruct.demo.entity.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO toCarDTO(Car car);
}
