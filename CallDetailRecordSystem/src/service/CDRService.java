package service;

import dao.CDRDao;
import model.CDR;

import java.util.List;

public class CDRService {
    private final CDRDao dao;

    public CDRService(CDRDao dao) {
        this.dao = dao;
    }

    public void recordCall(CDR cdr) {
        dao.addCDR(cdr);
    }

    public List<CDR> getUserCDRs(String mobile) {
        return dao.getCDRsByNumber(mobile);
    }

    public int getTotalCallDuration(String mobile) {
        return dao.getCDRsByNumber(mobile)
                .stream()
                .mapToInt(CDR::getDuration)
                .sum();
    }
}
