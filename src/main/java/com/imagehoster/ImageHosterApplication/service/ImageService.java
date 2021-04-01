package com.imagehoster.ImageHosterApplication.service;
import com.imagehoster.ImageHosterApplication.model.Image;
import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository image;
    public void createPost(Image newPost,MultipartFile file)
    {
        try
        {
            newPost.setImageFile(ConvertImgToBase64((file)));
            image.createPost(newPost);
        }
        catch(Exception e)
        {
            System.out.println("eroor");
            System.out.println(e);
        }

    }
    private String ConvertImgToBase64(MultipartFile file) throws IOException
    {
        return Base64.getEncoder().encodeToString(file.getBytes());
    }
    @Autowired
    private ImageRepository imageRepository;
    public List<Image> getAllPost(User user)
    {
        return imageRepository.getAllPosts(user);
    }
   public Image getImage(Integer postId)
   {
       return image.getImage(postId);
   }
    public void updatePost(Image updatedPost,MultipartFile file)
    {
        try
        {
            updatedPost.setImageFile(ConvertImgToBase64((file)));
            image.updatePost(updatedPost);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void deletePost(Integer postId)
    {
        image.deletePost(postId);
    }

}

