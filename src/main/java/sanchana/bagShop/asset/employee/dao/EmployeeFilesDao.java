package sanchana.bagShop.asset.employee.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sanchana.bagShop.asset.employee.entity.Employee;
import sanchana.bagShop.asset.employee.entity.EmployeeFiles;

import java.util.List;

@Repository
public interface EmployeeFilesDao extends JpaRepository< EmployeeFiles, Integer > {
    List< EmployeeFiles > findByEmployeeOrderByIdDesc(Employee employee);

    EmployeeFiles findByName(String filename);

    EmployeeFiles findByNewName(String filename);

    EmployeeFiles findByNewId(String filename);

    EmployeeFiles findByEmployee(Employee employee);
}