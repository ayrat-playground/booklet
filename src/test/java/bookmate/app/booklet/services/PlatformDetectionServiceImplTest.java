package bookmate.app.booklet.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlatformDetectionServiceImplTest {
  @Test
  public void shouldDetectAndroidUserAgent() {
    String userAgent = "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    PlatformDetectionServiceImpl service = new PlatformDetectionServiceImpl(userAgent);

    assertTrue(service.detect() == "Android");
  }

  @Test
  public void shouldDetectWpUserAgent() {
    String userAgent = "Mozilla/4.0(compatible; MSIE 6.0; Windows NT 5.1; Motorola_ES405B_19103; Windows Phone 8.5.3.5)";
    PlatformDetectionServiceImpl service = new PlatformDetectionServiceImpl(userAgent);

    assertTrue(service.detect() == "WP");
  }

  @Test
  public void shouldDetectIosUserAgent() {
    String userAgent = "Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A465 Safari/8536.25 (3B92C18B-D9DE-4CB7-A02A-22FD2AF17C8F)";
    PlatformDetectionServiceImpl service = new PlatformDetectionServiceImpl(userAgent);

    assertTrue(service.detect() == "iOS");
  }

  @Test
  public void shouldDetectWebUserAgent() {
    String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3033.0 Safari/537.36";
    PlatformDetectionServiceImpl service = new PlatformDetectionServiceImpl(userAgent);

    assertTrue(service.detect() == "Web");
  }

}