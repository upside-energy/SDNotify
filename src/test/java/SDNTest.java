import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sun.jna.Platform;

import info.faljse.SDNotify.SDNotify;
import info.faljse.SDNotify.jna.CLibrary;

public class SDNTest {
  @Test
  public void getPidReturnsInteger() {
    Assertions.assertEquals(false, Platform.isWindows());
    int pid = CLibrary.clib.getpid();
    assert (pid > 1);
  }

  @Test
  public void availableReturnsFalse() {
    assert (SDNotify.isAvailable() == false);
  }

}
