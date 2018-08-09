package com.jim.annotation.user.mapstruct.demo;
import com.jim.annotation.user.mapstruct.demo.entity.Car;
import com.jim.annotation.user.mapstruct.demo.entity.CarDTO;
import com.jim.annotation.user.mapstruct.demo.entity.CarType;
import com.jim.annotation.user.mapstruct.demo.mapper.CarMapper;
import org.junit.Assert;
import org.junit.Test;


public class CarMapperTest {

    @Test
    public void testCarMapper(){
        Car car1 = new Car();
        car1.setMake("上汽");
        car1.setNumberOfSeats("5");
        car1.setType(CarType.SEDAN);
        CarDTO carDTO = CarMapper.INSTANCE.toCarDTO(car1);


        Assert.assertEquals(carDTO.getMake(), "上汽");
        Assert.assertEquals(carDTO.getSeatCount(), Integer.parseInt(car1.getNumberOfSeats()));
        System.out.println(carDTO);

    }
}
