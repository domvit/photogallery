package codeforfood.controllers;

import codeforfood.util.Photos;
import codeforfood.util.Styles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class PhotoGalleryController {

    /**
     *
     * @param model in Spring MVC
     * @return view with form
     */

    @RequestMapping(value="/photo", method=RequestMethod.GET)
    public String index(Model model) {
        Photos.getInstance().clearPhotos();
        return "index";
    }
    /**
     *
     * @param pathName path typed by user
     * @param model in Spring MVC
     * @return view with uploaded photos
     */

    @RequestMapping(value="/photo", method=RequestMethod.POST)
    public String photoSubmit(@RequestParam("pathName") String pathName, Model model) {
        Photos photos = Photos.getInstance();
        Styles styles = new Styles();
        StringBuilder message = new StringBuilder("");
        File destFolder = new File(pathName);
        photos.scanFolders(destFolder);
        message.append(photos.getCountPhotos());
        model.addAttribute("style", styles);
        model.addAttribute("photos",photos.getPhotos());
        model.addAttribute("name",message);
        return "photo";
    }
}