
package edu.uniandes.hotelandes.dataGenerator;

import java.sql.SQLException;

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
    public void insertData() {
        dataGeneratorService.insertData();
    }

    @DeleteMapping
    public void deleteData() {
        dataGeneratorService.deleteDataBase();
    }

    @PostMapping("/tables")
    public void createTables() throws SQLException {
        dataGeneratorService.createTables();
        // dataGeneratorService.insertData();
    }

    @DeleteMapping("/tables")
    public void dropTables() throws SQLException {
        dataGeneratorService.dropTables();
    }

    @PostMapping("/tables/reset")
    public void resetTables() throws SQLException {
        this.dropTables();
        this.createTables();
    }
}