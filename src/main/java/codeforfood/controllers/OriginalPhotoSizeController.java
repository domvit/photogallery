package codeforfood.controllers;

import codeforfood.util.Photos;
import codeforfood.util.Styles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OriginalPhotoSizeController {

  /**
   *
   * @param model in Spring MVC
   * @return view with original size photo
   */
  @RequestMapping("/photo/original")
  public String photoOriginal(String name, Model model) {
    Photos photos = Photos.getInstance();
    Styles styles = new Styles();
    styles.setOriginal("original");
    StringBuilder message = new StringBuilder("");
    message.append(photos.getCountPhotos());
    model.addAttribute("style", styles);
    model.addAttribute("photos",photos.getPhotos());
    model.addAttribute("name",message);
    return "photo";
  }
}
