package anuda.me.yearbook.controllers;


import anuda.me.yearbook.entities.Videos;
import anuda.me.yearbook.repositories.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "videos")
public class MainController {


    @Autowired
    private VideosRepository videosRepository;


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseEntity<?> getVideosByQR(@RequestParam String qrText){

        Videos video = videosRepository.findByQrText(qrText);

        if(video==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            video.setViews(video.getViews()+1);
            videosRepository.save(video);
            return new ResponseEntity<Object>(video, HttpStatus.OK);
        }

    }
}
