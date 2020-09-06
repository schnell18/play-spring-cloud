package tk.tinkerit.cloudplay.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tk.tinkerit.cloudplay.jpa.model.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
