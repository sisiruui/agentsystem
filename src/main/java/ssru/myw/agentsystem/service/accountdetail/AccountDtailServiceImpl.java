package ssru.myw.agentsystem.service.accountdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.AccountDetailMapper;
import ssru.myw.agentsystem.doye.AccountdetailMapper;

/**
 * @author: mayiwen
 * @date: 2018/12/19
 */
@Service
@Transactional(readOnly=true)
public class AccountDtailServiceImpl implements AccountDetailService {
    @Autowired
    private AccountDetailMapper accountDetailMapper;
}
