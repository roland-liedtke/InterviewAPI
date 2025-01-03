package me.rolandliedtke.interviewapi.repository;

import me.rolandliedtke.interviewapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
