package com.everest.employee.models;

import com.everest.employee.entities.Employee;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class EmployeesResult {
    private List<Employee> data;
    private long totalElements;
    private long totalPages;
    private long pageSize;
    private long currentPage;
    private boolean hasNext;
    private boolean hasPrevious;

    public EmployeesResult(Page<Employee> employeePage) {
        this.setData(employeePage.getContent());
        this.setTotalElements(employeePage.getTotalElements());
        this.setTotalPages(employeePage.getTotalPages());
        this.setCurrentPage(employeePage.getNumber()+1);
        this.setPageSize(employeePage.getSize());
        this.setHasNext(employeePage.hasNext());
        this.setHasPrevious(employeePage.hasPrevious());
    }
}