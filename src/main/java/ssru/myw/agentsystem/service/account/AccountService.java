package ssru.myw.agentsystem.service.account;

import ssru.myw.agentsystem.entity.Account;

public interface AccountService {
    Account getAccountByUserId(Integer userId);
}
