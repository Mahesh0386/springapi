package io.bhannur.controller;

import io.bhannur.entity.Employee;
import io.bhannur.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
//@ResponseBody // Then we can remove this annotation for every method
@RestController // Combines Controller + ResponseBody
// Controller Needs a view resolver and a model attributes , while in Rest Controller it every response from the function need to be written on response body  knows that there is no view
@RequestMapping(value ="/employees") // Then we can remove this annotation for every method
public class EmployeeController {

@Autowired
private EmployeeService service;

    // Method should have unique RequestMapping
    @RequestMapping(method= RequestMethod.GET)
   // @ResponseBody
    public List<Employee> findAll() {
    return service.findAll();
    }

    // Path parameters
    @RequestMapping(method= RequestMethod.GET, value ="/{id}")
   // @ResponseBody
    public Employee findOne(@PathVariable("id") String id) {

        return service.findOne(id);
    }

    @RequestMapping(method= RequestMethod.POST)
   // @ResponseBody
    public Employee create(@RequestBody Employee emp) {
        return service.create(emp);
    }

    @RequestMapping(method= RequestMethod.PUT, value ="/{id}")
   // @ResponseBody
    public Employee update(String id, @RequestBody Employee emp) {
        return service.update(id,emp);
    }

    @RequestMapping(method= RequestMethod.DELETE, value ="/{id}")
   // @ResponseBody
    public void delete(String id)
    {
    service.delete(id);
    }
}
