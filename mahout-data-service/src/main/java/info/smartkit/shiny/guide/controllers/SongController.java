package info.smartkit.shiny.guide.controllers;

import info.smartkit.shiny.guide.domain.dao.MemberDao;
import info.smartkit.shiny.guide.domain.dao.SongDao;
import info.smartkit.shiny.guide.domain.dto.JsonObject;
import info.smartkit.shiny.guide.service.SongService;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，挖掘哪些歌曲是相似的
     */
    @RequestMapping(value = "similiar/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据用户听歌记录、歌曲信息和用户个人信息，挖掘哪些歌曲是相似的.")
    public List<RecommendedItem> getSongsWithLikehood(@PathVariable("id") String uid) throws IOException, TasteException {
        return this.songService.getSongsWithLikehood(uid);
    }

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，从而可以自动生成不同主题的歌单
     */
    @RequestMapping(value = "themes/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据用户听歌记录、歌曲信息和用户个人信息，从而可以自动生成不同主题的歌单.")
    public JsonObject getSongsWithDiffThemes(@PathVariable("id") String uid) {
        return new JsonObject(this.songService.getSongsWithDiffThemes(uid));
    }

    /**
     * 根据用户听歌记录、歌曲信息和用户个人信息，也可以向用户推荐其感兴趣的歌曲
     */
    @RequestMapping(value = "recommend/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据用户听歌记录、歌曲信息和用户个人信息，也可以向用户推荐其感兴趣的歌曲.")
    public JsonObject getSongsWithRecommendation(@PathVariable("id") String uid) {
        return new JsonObject(this.songService.getSongsWithRecommendation(uid));
    }
}
