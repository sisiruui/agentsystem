package ssru.myw.agentsystem.service.keywords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.KeywordsMapper;
import ssru.myw.agentsystem.entity.Keywords;

/**
 * @author: mayiwen
 * @date: 2018/11/29
 */
@Service
@Transactional(readOnly=true)
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public int count(Keywords keywords) {
        return keywordsMapper.count(keywords);
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int saveKeywords(Keywords keywords) {
        return keywordsMapper.saveKeywords(keywords);
    }
}
