package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Keywords;

public interface KeywordsMapper {
    int count(Keywords keywords);

    int saveKeywords(Keywords keywords);
}
