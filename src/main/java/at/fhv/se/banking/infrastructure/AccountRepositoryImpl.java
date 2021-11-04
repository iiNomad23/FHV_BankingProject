package at.fhv.se.banking.infrastructure;

import at.fhv.se.banking.domain.model.Account;
import at.fhv.se.banking.domain.repositories.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    private List<Account> accounts;

    private AccountRepositoryImpl() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public Optional<Account> getByIban(String iban) {
        return accounts.stream()
                .filter(a -> a.getIban().equals(iban))
                .findFirst();
    }

    @Override
    public List<Account> getByOwnerNumber(String customerNumber) {
        return accounts.stream()
                .filter(a -> a.getOwner().getCustomerNumber().equals(customerNumber))
                .collect(Collectors.toList());
    }
}
