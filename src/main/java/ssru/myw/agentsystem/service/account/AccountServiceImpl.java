package ssru.myw.agentsystem.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.AccountMapper;
import ssru.myw.agentsystem.entity.Account;

/**
 * @author: mayiwen
 * @date: 2018/11/29
 */
@Service
@Transactional(readOnly=true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountByUserId(Integer userId) {
        return accountMapper.getAccountByUserId(userId);
    }
}
