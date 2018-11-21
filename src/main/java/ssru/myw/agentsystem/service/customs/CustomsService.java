package ssru.myw.agentsystem.service.customs;

import ssru.myw.agentsystem.entity.Customs;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.util.List;

public interface CustomsService {
    List<Customs> listCustoms(Customs customs, PageNumberCareTaker pageNumberCareTaker);
}
