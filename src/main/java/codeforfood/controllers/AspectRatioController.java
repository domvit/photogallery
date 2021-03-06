package codeforfood.controllers;

import codeforfood.util.Photos;
import codeforfood.util.Styles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AspectRatioController {

    /**
     *
     * @param string
     * @param model in Spring MVC
     * @return view with default size photo
     */
    @RequestMapping("/photo/wh/{string}")
    public String photoRow(@PathVariable final String string, Model model) {
        String[] args = string.split("x|X");
        int weigth = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        Photos photos = Photos.getInstance();
        Styles styles = new Styles();
        styles.setRatio(weigth,height);
        StringBuilder message = new StringBuilder("");
        message.append(photos.getCountPhotos());
        model.addAttribute("style", styles);
        model.addAttribute("photos",photos.getPhotos());
        model.addAttribute("name",message);
        return "photo";
    }
}
