package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BodyInfoService {
    @Autowired
    private  BodyInfoRepository bodyInfoRepository;
    private List<BodyInfo> bodyInfos = new ArrayList<>();

    public void setBodyInfos(List<BodyInfo> bodyInfos) { this.bodyInfos = bodyInfos; }
    public void addBody(BodyInfo bodyInfo) {bodyInfos.add(bodyInfo);}
    public List<BodyInfo> returnBodyInfos(){return this.bodyInfos;}
    public String greet(){return "Hi";}
    public List<BodyInfo> getBodyInfos(){
        List<BodyInfo> contacts =new ArrayList<>();
        bodyInfoRepository.findAll().forEach(contacts::add);
        return contacts;
    }

    public BodyInfo getBodyInfo(String id){
        System.out.println(bodyInfoRepository.findByName(id).size());
        BodyInfo bodyInfo = new BodyInfo();
        for (BodyInfo b : bodyInfoRepository.findByName(id)) {
            if(b.getName().equals(id)){
                bodyInfo=b;
            }
        }
        return  bodyInfo;
    }

    public void addBodyInfo(BodyInfo bodyInfo) {
        bodyInfoRepository.save(bodyInfo);
    }

    public void updateBodyInfo(String id, BodyInfo bodyInfo) { bodyInfoRepository.save(bodyInfo); }

    public void removeBodyInfo(String id){
         System.out.println(bodyInfoRepository.findByName(id).size());
         bodyInfoRepository.delete(bodyInfoRepository.findByName(id).get(0));
    }
}
