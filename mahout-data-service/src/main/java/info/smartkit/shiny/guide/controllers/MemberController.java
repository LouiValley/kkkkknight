package info.smartkit.shiny.guide.controllers;

import info.smartkit.shiny.guide.domain.dao.MemberDao;
import info.smartkit.shiny.guide.domain.dto.JsonObject;
import info.smartkit.shiny.guide.domain.dto.SongFullInfo;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by smartkit on 20/02/2017.
 */
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 获取用户听歌记录
     */
    @RequestMapping(value = "history/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "获取用户听歌记录.")
    public List<Song> getSongHistory(@PathVariable("id") String uid) {
        return this.memberService.getSongHistory(uid);
    }
    /**
     * 获取用户歌曲信息
     */
    @RequestMapping(value = "song/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "获取用户歌曲信息.")
    public List<SongFullInfo> getSongInfo(@PathVariable("id") String uid) {
        return this.memberService.getSongFullInfo(uid);
    }
    /**
     * 获取用户个人信息
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "获取用户个人信息.")
    public Member getUserInfo(@PathVariable("id") String uid) {
        return memberService.getUserInfo(uid);
    }
    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，挖掘哪些用户是相似的
     */
    @RequestMapping(value = "likehood/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据用户听歌记录、歌曲信息和用户个人信息，挖掘哪些用户是相似的.")
    public List<Object> getUsersWithLikehood(@PathVariable("id") String uid) {
        return memberService.getUsersWithLikehood(uid);
    }
    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，从而可以向用户推荐兴趣一致的其他用户
     */
    @RequestMapping(value = "likehood/recommend/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据用户听歌记录、歌曲信息和用户个人信息，从而可以向用户推荐兴趣一致的其他用户.")
    public List<Object> getUsersWithLikehoodAndRecommendation(@PathVariable("id") String uid) {
        return memberService.getUsersWithLikehoodAndRecommendation(uid);
    }
}
