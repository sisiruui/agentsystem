package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Customs;

import java.util.List;

public interface CustomsMapper {


    List<Customs> listCustoms(Customs customs);

    Integer countCustoms(Customs customs);

    int saveCustoms(Customs customs);

    int updateCustoms(Customs customs);
}
