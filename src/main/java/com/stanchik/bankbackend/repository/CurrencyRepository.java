package com.stanchik.bankbackend.repository;
import com.stanchik.bankbackend.model.Currency;
import org.springframework.data.repository.CrudRepository;
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
