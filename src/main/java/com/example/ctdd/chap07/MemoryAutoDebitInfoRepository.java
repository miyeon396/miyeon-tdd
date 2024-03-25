package com.example.ctdd.chap07;

import java.util.HashMap;
import java.util.Map;

public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
    //메모리에만 데이터가 저장되므로 DB와 같은 영속성을 제공하지는 않지만 테스트에 사용할 수 있을 만큼의 기능은 제공한다.
    private Map<String, AutoDebitInfo> infos = new HashMap<>();

    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
