package dao;

import model.CDR;
import java.util.ArrayList;
import java.util.List;

public class CDRDao {
    private final List<CDR> cdrList = new ArrayList<>();

    public void addCDR(CDR cdr) {
        cdrList.add(cdr);
    }

    public List<CDR> getAllCDRs() {
        return new ArrayList<>(cdrList);
    }

    public List<CDR> getCDRsByNumber(String number) {
        List<CDR> result = new ArrayList<>();
        for (CDR cdr : cdrList) {
            if (cdr.getCaller().equals(number) || cdr.getReceiver().equals(number)) {
                result.add(cdr);
            }
        }
        return result;
    }
}
