package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RestController
@Controller
public class AddressBookController  {

    @Autowired
    private  BodyInfoService bodyInfoService;

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String greet(){return bodyInfoService.greet();}

    @RequestMapping(value = "/bodyInfo", method = RequestMethod.GET)
    public String addressBookForm(Model model){
        BodyInfo buddy = new BodyInfo();
        model.addAttribute("bodyInfo", buddy);
        return  "AddressBookForm";
    }
    @RequestMapping(value = "/bodyInfo", method = RequestMethod.POST)
    public String addBodyInfo(@ModelAttribute BodyInfo bodyInfo, Model model){
        String name = bodyInfo.getName();
        System.out.println(name);
        System.out.println(bodyInfo.getPhoneNum());
        bodyInfoService.addBody(bodyInfo);
        model.addAttribute("bodyInfo", bodyInfo);
        return  "Home";
    }
    @GetMapping(value = "/all")
    public String getAllBuddies(Model model){
        model.addAttribute("buddies",bodyInfoService.returnBodyInfos());
        return  "allBuddies";
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
