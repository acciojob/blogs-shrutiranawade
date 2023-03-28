package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
 Blog blog = blogRepository2.findById(blogId).get();//find blog with id
 Image image = new Image(blog,description,dimensions);
 blog.getImageList().add(image);
 blogRepository2.save(blog);
 return image;
    }

    public void deleteImage(Integer id){
imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Image image = imageRepository2.findById(id).get();
        String imageDimensions = image.getDimensions();

        String [] imgd = imageDimensions.split("X");
        String [] scrd = screenDimensions.split("X");

        //image dimensions
        int imglen = Integer.parseInt(imgd[0]);
        int imgbre = Integer.parseInt(imgd[1]);
        //screen dimensions len,breadth

        int scrlen = Integer.parseInt(scrd[0]);
        int scrbre = Integer.parseInt(scrd[1]);

        return (scrlen/imglen) * (scrbre/imgbre);


    }
}
