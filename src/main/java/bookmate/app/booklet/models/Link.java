package bookmate.app.booklet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("links")
public class Link {
	
  @Id
  private String link;
  private String longLink;

  public Link(String link, String longLink) {
    this.link = link;
    this.longLink = longLink;
  }
}
