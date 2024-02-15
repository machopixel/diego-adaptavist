package com.adaptavist.diegocv.actions;

import com.adaptavist.diegocv.io.FileReadService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService {

  final FileReadService fileReadService;

  @Autowired
  public CountService(FileReadService fileReadService) {
    this.fileReadService = fileReadService;
  }

  public Map<String, Integer> countWordsAsMap(final String filePath) {
    final Map<String, Integer> wordCountMap = new HashMap<>();
    String fileContent = fileReadService.readEntireFile(filePath);

    fileContent = fileContent.replaceAll("[^a-zA-Z]", " ").toLowerCase();

    String[] words = fileContent.split(" ");
    for (String word : words) {
      if (!word.isEmpty()) {
        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
      }
    }

    return inDescendingOrderByValue(wordCountMap);
  }

  private Map<String, Integer> inDescendingOrderByValue(Map<String, Integer> wordCountMap) {
    return wordCountMap.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(
            LinkedHashMap::new,
            (map, entry) -> map.put(entry.getKey(), entry.getValue()),
            Map::putAll);
  }
}
