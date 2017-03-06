package bookmate.app.booklet.services;

import bookmate.app.booklet.domain.PlatformDetectionService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

public class PlatformDetectionServiceImpl implements PlatformDetectionService {
  private static final String android = "(.*)(Android)(.*)";
  private static final String windowsPhone = "(.*)(Windows Phone)(.*)";
  private static final String iOS = "(.*)((iOS)|(iPhone)|(iPad))(.*)";
  private String userAgent;

  @Autowired
  public PlatformDetectionServiceImpl(String userAgent) {
    this.userAgent = userAgent;
  }

  @Override
  public String detect() {
    if (isAndroid()) {
      return "Android";
    }
    else if (isWindowsPhone()) {
      return "WP";
    }
    else if (isIOS()) {
      return "iOS";
    }
    else {
      return "Web";
    }
  }

  private Boolean isAndroid() {
    return matcher(android).find();
  }

  private Boolean isIOS() {
    return matcher(iOS).find();
  }

  private Boolean isWindowsPhone() {
    return matcher(windowsPhone).find();
  }

  private Matcher matcher(String regexp) {
    Pattern pattern = Pattern.compile(regexp);
    return pattern.matcher(userAgent);
  }
}
