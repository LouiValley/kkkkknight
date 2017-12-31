package info.smartkit.shiny.guide.controllers;

import info.smartkit.shiny.guide.domain.dao.MemberDao;
import info.smartkit.shiny.guide.domain.dao.SongDao;
import info.smartkit.shiny.guide.domain.dto.JsonObject;
import info.smartkit.shiny.guide.service.SongService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，挖掘哪些歌曲是相似的
     */
    @RequestMapping(value = "history/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Response a string describing if the user info id is successfully get or not.")
    public JsonObject getSongsWithLikehood(@PathVariable("id") String uid) {
        return new JsonObject(this.songService.getSongsWithLikehood(uid));
    }

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，从而可以自动生成不同主题的歌单
     */
    @RequestMapping(value = "themes/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Response a string describing if the user info id is successfully get or not.")
    public JsonObject getSongsWithDiffThemes(@PathVariable("id") String uid) {
        return new JsonObject(this.songService.getSongsWithDiffThemes(uid));
    }

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，也可以向用户推荐其感兴趣的歌曲
     */
    @RequestMapping(value = "recommend/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Response a string describing if the user info id is successfully get or not.")
    public JsonObject getSongsWithRecommendation(@PathVariable("id") String uid) {
        return new JsonObject(this.songService.getSongsWithRecommendation(uid));
    }
}
