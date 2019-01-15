package com.yonetim;

import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.dto.YonetimDTO;
import com.yonetim.service.IYonetimService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.*;

@Controller
public class YonetimController {

    /**
     * genel olarak parametreli ve parametresiz ornekler,post,get ve navigation
     * @return
     */

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IYonetimService yonetimService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String read(Model model){
        YonetimDTO yonetimDTO = yonetimService.getId(1);
        model.addAttribute("yonetimDTO",yonetimDTO);
        return "start";
    }

    //object olarak dönüş,ResponseBody örneği...
    @RequestMapping(value = "/object", method = RequestMethod.GET)
    @ResponseBody
    public YonetimDTO send(Model model){
        YonetimDTO yonetimDTO = yonetimService.getId(1);
        model.addAttribute("yonetimDTO",yonetimDTO);
        return yonetimDTO;
    }

    @RequestMapping(value = "/saveYonetim", method = RequestMethod.GET)
    public String saveYonetim(YonetimDTO yonetimDTO){
        yonetimDTO.setId(11);
        yonetimDTO.setAd("x");
        yonetimDTO.setSoyad("y");
        yonetimDTO.setAciklama("z");
        try {
            yonetimService.save(yonetimDTO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return "error";
        }
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET,headers = {"content-type=text/json"})
    public String readJSON(){
        return "start";
    }

    @RequestMapping(value = "/addYonetim", method = RequestMethod.GET)
    public String addYonetim(){
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET,params = {"loyalty=blue"})
    public String readBlue(){
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET,params = {"loyalty=silver"})
    public ModelAndView readSilver(){
        YonetimDTO yonetimDTO = yonetimService.getId(3);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        modelAndView.addObject("yonetimDTO",yonetimDTO);
        return modelAndView;
    }

    //@RequestMapping(value = "/start", method = RequestMethod.POST) alttaki notasyon yeni hali ikiside aynı aslında
    @PostMapping("/start")
    public String create(){
        return "start";
    }

    //domain end-point olarak ayarlanır...
    @RequestMapping("")
    public String index(){
        logger.info("Kullanıcı geldi");
        return "login";
    }

    //domain end-point olarak ayarlanır ...com/start
    @RequestMapping("/start")
    public String start(){
        return "start";
    }

    //getmapping örneği...
    @GetMapping("/ara1")
    public String ara1(@RequestParam(value = "arama",required = true , defaultValue = "") String aranacak){
        String son = aranacak + "";
        return "start";
    }

    //getmapping örneği,front-end obje olarak geldi...
    @GetMapping("/araManuel")
    public ModelAndView araManuel(@RequestParam Map<String,String> requestParam){
        int son = requestParam.size();
        String aranacak = requestParam.get("arama");
        ModelAndView modelAndView = new ModelAndView();
        List<SahipDTO> list = new ArrayList<SahipDTO>();
        try {
            list = yonetimService.kayitAlManuel(aranacak);
            modelAndView.setViewName("start");
            //modelAndView.addObject("sahipDTO",list);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("sahipDTO",list);
        return modelAndView;
    }

    //getmapping örneği,front-end obke olarak geldi...
    @GetMapping("/ara")
    public ModelAndView ara(@RequestParam Map<String,String> requestParam){
        logger.debug("Arama başladı...");
        int son = requestParam.size();
        String aranacak = requestParam.get("arama");
        ModelAndView modelAndView = new ModelAndView();
        List<PlantDTO> list = new ArrayList<PlantDTO>();
        try {
            list = yonetimService.kayitAl(aranacak);
            logger.info("Sonuç = " +list.size());
            logger.warn("Sonuç = " +list.size());
            modelAndView.setViewName("start");
            if(list.size() == 0){
                logger.warn("Arama sonucu bulunamadı = " +aranacak);
            }
            //modelAndView.addObject("sahipDTO",list);
        } catch (Exception e) {
            logger.error("Arama yaparken hata aldı",e);
            e.printStackTrace();
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("sahipDTO",list);
        logger.debug("Arama bitti...");
        return modelAndView;
    }

    @RequestMapping("/go")
    public String go(){
        return "go";
    }
}