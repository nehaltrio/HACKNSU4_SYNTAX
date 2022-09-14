package com.example.hacknsu4_trafficapp.Controllers;

import com.example.hacknsu4_trafficapp.Models.*;
import com.example.hacknsu4_trafficapp.Repositories.*;
import com.example.hacknsu4_trafficapp.SecurityConfigs.BusOwnerDetails;
import com.example.hacknsu4_trafficapp.Utills.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BusOwnerRepo busOwnerRepo;

    @Autowired
    BusQrRepo busQrRepo;

    @Autowired
    BusRepo busRepo;

    @Autowired
    BusRouteRepo busRouteRepo;

    @Autowired
    PostDetailsRepo postDetailsRepo;

    @GetMapping("/bus_owner/login")
    public String viewBusOwnerLoginPage() {
        return "bus_owner/bus_owner_login";
    }


    @GetMapping("/bus_owner_register")
    public String launchBusOwnerRegPage(Model model) {
        model.addAttribute("bus_owner", new BusOwner());
        return "bus_owner/bus_owner_register";
    }

    @RequestMapping("/bus_owner_registration_process")
    public String processBusOwnerRegister(BusOwner busOwner) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(busOwner.getBusOwnerPass());
        busOwner.setBusOwnerPass(encodedPassword);

        busOwnerRepo.save(busOwner);

        return "bus_owner/bus_owner_login";
    }



    @GetMapping("/bus_info")
    public String launchBusDataInputPage(Model model, @AuthenticationPrincipal BusOwnerDetails busOwnerDetails, Bus bus) {

        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        model.addAttribute("owner", busOwner);
        model.addAttribute("bus", bus);
        return "bus_info/bus_details";
    }


    @RequestMapping("/bus_info_update_process")
    public String processBusInfo(Bus bus, @AuthenticationPrincipal BusOwnerDetails busOwnerDetails) {
        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        bus.setOwnerName(busOwner.getBusOwnerName());
        busRepo.save(bus);
        return "redirect:/";
    }


    @PostMapping(value = "/genrateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQRCode(Bus bus, @RequestParam String busName)
            throws Exception {

        bus = busRepo.findBus(busName);
        String codeText = bus.toString();

        return okResponse(QRCodeGenerator.getQRCodeImage(codeText));
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    @GetMapping("/")
    public String findBusByLocation() {
        return "index.html";
    }

    @RequestMapping("/searchBus")
    public String bus(@ModelAttribute GetRequiredBus getRequiredBus, Model model) {
        String loc = getRequiredBus.getLocation();
        String dest = getRequiredBus.getDestination();

        List<Route> busRouteList = busRouteRepo.findBus(loc, dest);

        model.addAttribute("busList", busRouteList);

        return "tableindex.html";
    }

    @GetMapping("/portal")
    public String viewPortalPage(Model model , PostDetails postDetails){
        model.addAttribute("feed", postDetails);
        return "portal";
    }


    @RequestMapping("/proccess_portal")
    public String launchPortalResult(PostDetails postDetails){
        postDetailsRepo.save(postDetails);
        return "redirect:/portal";
    }

    @RequestMapping("/feed")
    public String feedback(Model model){
        List<PostDetails> list = postDetailsRepo.findDetails();
        model.addAttribute("feed", list);
        return "feedbackindex";
    }

    @GetMapping("/bus_home")
    public String viewBusHome(Model model, @AuthenticationPrincipal BusOwnerDetails busOwnerDetails){
        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        model.addAttribute("bus_owner", busOwner);
        return "busownerportal";
    }


    @GetMapping("bus_owner_home")
    public String busOwnerHome(@AuthenticationPrincipal BusOwnerDetails busOwnerDetails, Model model){
        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        model.addAttribute("busowner", busOwner);
        return "busownerportal";
    }
    

}
