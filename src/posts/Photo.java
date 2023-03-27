package posts;

public class Photo extends Post{
    private final String photoContent;
    private final String imageUrl;

    public Photo(String caption, String photoContent) {
        super(caption);
        this.photoContent = photoContent;
        this.imageUrl = "image_url";
    }

    public String getPhotoContent() {
        return photoContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
