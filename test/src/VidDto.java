import java.io.Serializable;

/**
 * Created by xiongjiaxin on 2017/7/25.
 */
public class VidDto implements Serializable {
    private String videoUnique;

    private String cover;           // 封面

    private int appId;

    private String status;

    private String videoId;         // VID

    private String videoDuration;   // 视频时长

    private int code;               // 0是正常 -1出现异常

    public String getVideoUnique() {
        return videoUnique;
    }

    public void setVideoUnique(String videoUnique) {
        this.videoUnique = videoUnique;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
