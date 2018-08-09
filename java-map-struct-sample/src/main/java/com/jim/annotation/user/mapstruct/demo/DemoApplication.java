package com.jim.annotation.user.mapstruct.demo;
import com.jim.annotation.user.mapstruct.demo.entity.Car;
import com.jim.annotation.user.mapstruct.demo.entity.CarDTO;
import com.jim.annotation.user.mapstruct.demo.entity.CarType;
import com.jim.annotation.user.mapstruct.demo.mapper.CarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jim.annotation.user.mapstruct.demo.mapper")
public class DemoApplication implements CommandLineRunner {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    CarMapper carMapper;
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CarDTO getCarDTO() {
        Car car1 = new Car();
        car1.setMake("上汽");
        car1.setNumberOfSeats("5");
        car1.setType(CarType.SEDAN);
        return carMapper.toCarDTO(car1);
    }

    @Override
    public void run(String... args) throws Exception {
        CarDTO carDTO = context.getBean(CarDTO.class);
        LOGGER.debug(carDTO.toString());
        System.out.println("==============================>" + carDTO.toString());
    }
}
