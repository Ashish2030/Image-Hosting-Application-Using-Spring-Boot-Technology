package com.imagehoster.ImageHosterApplication.controller;
import com.imagehoster.ImageHosterApplication.model.Image;
import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.*;
@Controller
public class ImageController
{
    @Autowired
    private ImageService image;
    @RequestMapping(value="/print_page")
    public String getUserPost(Model model,HttpSession session)
    {
        User user=(User)session.getAttribute("LoggedUser");
        List <Image> image1 = image.getAllPost(user);
        model.addAttribute("images", image1);
        return "/Print/print";
    }

    @RequestMapping(value="/")
    public String temp()
    {
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/upload")
    public String newImage()
    {
        return "Upload/Upload";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/upload_Successful")
    public String createNewImage( @RequestParam ("file") MultipartFile file, Image  newPost, HttpSession session)
    {
        User user=(User)session.getAttribute("LoggedUser");
        newPost.setUser(user);
        newPost.setDate(new Date());
        image.createPost(newPost,file);
        return "redirect:/print_page";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/editpost")
    public String editPost( @RequestParam (name="postId") Integer postId,Model model)
    {
        Image image1=image.getImage(postId);
        model.addAttribute("post",image1);
        return "/Edit_page/edit_page";
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/editpost_successful")
    public String editPostSubmit(@RequestParam (name="postId" ) Integer postId ,@RequestParam ("file") MultipartFile file,Image updateImgData,HttpSession session)
    {
        updateImgData.setId(postId);
         updateImgData.setDate((new Date()));
        User user=(User)session.getAttribute("LoggedUser");
        updateImgData.setUser(user);
        image.updatePost(updateImgData,file);
        return "redirect:/print_page";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletepost")
    public String deletePost(@RequestParam(name = "postId") Integer postId)
    {
        image.deletePost(postId);
        return "redirect:/print_page";
    }


}

