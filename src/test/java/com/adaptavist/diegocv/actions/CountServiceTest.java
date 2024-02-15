package com.adaptavist.diegocv.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.adaptavist.diegocv.io.FileReadService;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CountServiceTest {

  @Mock private FileReadService fileReadService;

  private CountService countService;

  @BeforeEach
  public void setUp() {
    countService = new CountService(fileReadService);
  }

  @Test
  public void testCountWordsAsMap() {
    String filePath = "test.txt";
    String fileContent = "hello world hello";
    when(fileReadService.readEntireFile(filePath)).thenReturn(fileContent);

    Map<String, Integer> wordCountMap = countService.countWordsAsMap(filePath);

    assertEquals(2, wordCountMap.get("hello"));
    assertEquals(1, wordCountMap.get("world"));
  }

  @Test
  public void testCountWordsAsMapWithEmptyContent() {
    String filePath = "empty.txt";
    String fileContent = "";
    when(fileReadService.readEntireFile(filePath)).thenReturn(fileContent);

    Map<String, Integer> wordCountMap = countService.countWordsAsMap(filePath);

    assertEquals(0, wordCountMap.size());
  }

  @Test
  public void testCountWordsAsMapWithSpecialCharacters() {
    String filePath = "special.txt";
    String fileContent = "hello world! hello...";
    when(fileReadService.readEntireFile(filePath)).thenReturn(fileContent);

    Map<String, Integer> wordCountMap = countService.countWordsAsMap(filePath);

    assertEquals(2, wordCountMap.get("hello"));
    assertEquals(1, wordCountMap.get("world"));
  }
}
