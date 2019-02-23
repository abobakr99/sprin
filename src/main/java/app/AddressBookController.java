package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//@RestController
@Controller
public class AddressBookController  {

    @Autowired
    private  BodyInfoService bodyInfoService;

    @RequestMapping(value = "/bodyInfo", method = RequestMethod.GET)
    public String addressBookForm(){
        return  "AddressBookForm";
    }
    @RequestMapping(value = "/bodyInfo", method = RequestMethod.POST)
    public String addBodyInfo(@ModelAttribute(name= "bodyInfo" ) BodyInfo bodyInfo , Model model){
        String name = bodyInfo.getName();
        String phoneNum = Integer.toString(bodyInfo.getPhoneNum());
        if ("admin".equals(name) )
            return "home";
        return  "AddressBookForm";
    }

   @RequestMapping(value = "/bodyInfos", method = RequestMethod.GET)
    public List<BodyInfo> getContacts(){
        return bodyInfoService.getBodyInfos();
    }
    @RequestMapping("/bodyInfos/{id}")
    public BodyInfo getBodyInof(@PathVariable String id){
       return bodyInfoService.getBodyInfo(id);
    }
    @RequestMapping(method= RequestMethod.POST, value = "/bodyInfos")
    public  void adddBodyInfo(@RequestBody BodyInfo bodyInfo){
       bodyInfoService.addBodyInfo(bodyInfo);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/bodyInfos/{id}")
    public  void updateBodyInfo(@RequestBody BodyInfo bodyInfo, @PathVariable String id){
        bodyInfoService.updateBodyInfo(id, bodyInfo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/bodyInfos/{id}")
    public  void removeBodyInfo(@PathVariable String id){
        System.out.println("contrller called");
        System.out.println();
        bodyInfoService.removeBodyInfo(id);
    }
}
