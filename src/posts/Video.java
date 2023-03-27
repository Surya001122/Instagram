package posts;

public class Video extends Post{
    private final String videoContent;
    private final String videoUrl;
    private final int durationInSeconds;

    public Video(String caption, String videoContent) {
        super(caption);
        this.videoContent = videoContent;
        this.videoUrl = "video_url";
        this.durationInSeconds = 30;
    }

    public String getVideoContent() {
        return videoContent;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }
}
