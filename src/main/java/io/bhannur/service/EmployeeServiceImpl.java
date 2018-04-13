package io.bhannur.service;

import io.bhannur.entity.Employee;
import io.bhannur.exception.BadRequestException;
import io.bhannur.exception.EntityNotFoundException;
import io.bhannur.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(String id) {
        Employee emp = repository.findOne(id);
                if(emp == null)
                {
                    throw new EntityNotFoundException(("Employee not found!"));
                }
       return emp;
    }

    @Override
    @Transactional
    public Employee create(Employee emp) {
        Employee existingEmail = repository.findByEmail(emp.getEmail());
        if(existingEmail != null)
        {
            throw new BadRequestException(("Employee already exist with the given email!"));
        }
        return repository.create(emp);
    }

    @Override
    @Transactional
    public Employee update( String id, Employee emp) {
        Employee existing = repository.findOne(id);
        if(existing == null)
        {
            throw new EntityNotFoundException(("Employee not found!"));
        }
        return repository.update(emp);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Employee existing = repository.findOne(id);
        if(existing == null)
        {
            throw new EntityNotFoundException(("Employee not found!"));
        }
        repository.delete(existing);
    }
}
