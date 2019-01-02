package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Account;

public interface AccountMapper {
    Account getAccountByUserId(Integer userId);
}
