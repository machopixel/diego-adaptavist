package com.adaptavist.diegocv.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileReadServiceTest {

  private FileReadService fileReadService;

  @BeforeEach
  public void setUp() {
    fileReadService = new FileReadService();
  }

  @Test
  public void testReadEntireFile() {
    String filePath = "test1.txt";
    String expectedContent = "hello world ";

    String content = fileReadService.readEntireFile(getTestFilePath(filePath));

    assertEquals(expectedContent, content);
  }

  @Test
  public void testReadEntireFileMultiline() {
    String filePath = "test2.txt";
    String expectedContent = "hello world hello world ";

    String content = fileReadService.readEntireFile(getTestFilePath(filePath));

    assertEquals(expectedContent, content);
  }

  @Test
  public void testReadEntireFileMultilineSymbol() {
    String filePath = "test2.txt";
    String expectedContent = "hello world hello world ";

    String content = fileReadService.readEntireFile(getTestFilePath(filePath));

    assertEquals(expectedContent, content);
  }

  @Test
  public void testReadEntireFileException() {
    String filePath = "non-existent-file.txt";

    String content = fileReadService.readEntireFile(filePath);

    assertEquals("", content);
  }

  private String getTestFilePath(final String string) {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resourceUrl = Objects.requireNonNull(classLoader.getResource(string));
    try {
      return Paths.get(resourceUrl.toURI()).toString();
    } catch (URISyntaxException e) {
      throw new RuntimeException("Unable to convert URL to URI: " + resourceUrl, e);
    }
  }
}
