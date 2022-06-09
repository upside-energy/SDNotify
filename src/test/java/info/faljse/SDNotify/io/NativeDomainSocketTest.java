package info.faljse.SDNotify.io;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import info.faljse.SDNotify.SDNotifyException;
import info.faljse.SDNotify.jna.CLibrary;

class NativeDomainSocketTest {

  @Test
  public void send_responseDifferentThanExpected_throwsException() {
    CLibrary cLibraryMock = Mockito.mock(CLibrary.class);
    doReturn(12345).when(cLibraryMock).send(anyInt(), ArgumentMatchers.any(Buffer.class), anyInt(), anyInt());

    final NativeDomainSocket nativeDomainSocket = new NativeDomainSocket(cLibraryMock);

    assertThatExceptionOfType(SDNotifyException.class).isThrownBy(
        () -> nativeDomainSocket.send("".getBytes(StandardCharsets.UTF_8), 0))
        .withMessage("Unexpected return from writing to socket");
  }

  @Test
  public void send_responseReturnsMinusOne_throwsException() {
    CLibrary cLibraryMock = Mockito.mock(CLibrary.class);
    doReturn(-1).when(cLibraryMock).send(anyInt(), ArgumentMatchers.any(Buffer.class), anyInt(), anyInt());

    final NativeDomainSocket nativeDomainSocket = new NativeDomainSocket(cLibraryMock);

    assertThatExceptionOfType(SDNotifyException.class).isThrownBy(
            () -> nativeDomainSocket.send("".getBytes(StandardCharsets.UTF_8), 0))
        .withMessage("Error while sending message to socket");
  }

}
