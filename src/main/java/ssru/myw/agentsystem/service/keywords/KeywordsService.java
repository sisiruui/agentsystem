package ssru.myw.agentsystem.service.keywords;

import ssru.myw.agentsystem.entity.Keywords;

public interface KeywordsService {
    int count(Keywords keywords);

    int saveKeywords(Keywords keywords);
}
