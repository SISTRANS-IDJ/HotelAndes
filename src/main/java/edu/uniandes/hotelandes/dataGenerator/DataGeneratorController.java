
package edu.uniandes.hotelandes.dataGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/insert-data")
public class DataGeneratorController {
    @Autowired
    private DataGeneratorService dataGeneratorService;

    @PostMapping
    public void insertData(){
        dataGeneratorService.insertRoles();
    }

    @DeleteMapping
    public void deleteData(){
        dataGeneratorService.deleteDataBase();
    }
    
}