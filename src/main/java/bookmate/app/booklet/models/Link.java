package bookmate.app.booklet.models;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("links")
public class Link {
	
  @Id
  @NotNull
  private String link;
  @NotNull
  private String webLink;
  private String androidLink;
  private String iosLink;
  private String wpLink;

  public Link(String link,
      String webLink,
      String androidLink,
      String iosLink,
      String wpLink) {
    this.link = link;
    this.webLink = webLink;
    this.androidLink = androidLink;
    this.iosLink = iosLink;
    this.wpLink = wpLink;
  }

  public Link(String link, String webLink) {
    this.link = link;
    this.webLink = webLink;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getWebLink() {
    return webLink;
  }

  public void setWebLink(String webLink) {
    this.webLink = webLink;
  }

  public String getAndroidLink() {
    return androidLink;
  }

  public void setAndroidLink(String androidLink) {
    this.androidLink = androidLink;
  }

  public String getIosLink() {
    return iosLink;
  }

  public void setIosLink(String iosLink) {
    this.iosLink = iosLink;
  }

  public String getWpLink() {
    return wpLink;
  }

  public void setWpLink(String wpLink) {
    this.wpLink = wpLink;
  }

  public String getLinkWithFallback(String platform) {
    String platformLink = getLinkByPlatform(platform);

    return platformLink == null ? webLink : platformLink;
  }

  private String getLinkByPlatform(String platform) {
    switch (platform) {
      case("Android"): return androidLink;
      case("iOS"): return iosLink;
      case("WP"): return wpLink;
      default: return webLink;
    }
  }
}
