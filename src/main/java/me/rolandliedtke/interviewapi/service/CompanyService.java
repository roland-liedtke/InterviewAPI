package me.rolandliedtke.interviewapi.service;

import me.rolandliedtke.interviewapi.exception.CompanyNotFoundException;
import me.rolandliedtke.interviewapi.model.Company;
import me.rolandliedtke.interviewapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Simply CRUD
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company readCompanyById(Long id) throws CompanyNotFoundException {
        return companyRepository.findById(id)
                .orElseThrow(CompanyNotFoundException::new);
    }

    public Company updateCompanyOnId(Long id, Company updatedCompany) {
        companyRepository.findById(id)
                .map(company -> {
                    company.setName(updatedCompany.getName());
                    company.setAddress(updatedCompany.getAddress());
                    company.setPhoneNumber(updatedCompany.getPhoneNumber());
                    company.setEmail(updatedCompany.getEmail());
                    return companyRepository.save(company);
                });
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }


    // Get All Companies
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }






}
