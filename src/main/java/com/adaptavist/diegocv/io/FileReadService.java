package com.adaptavist.diegocv.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileReadService {
  private static final Logger logger = LoggerFactory.getLogger(FileReadService.class);

  public String readEntireFile(String filePath) {
    try {
      logger.info("Reading file {}", filePath);
      List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
      StringBuilder content = new StringBuilder();
      for (String line : lines) {
        content.append(line).append(" ");
      }
      return content.toString();
    } catch (IOException ioException) {
      logger.error("Error reading file {}", filePath, ioException);
      return "";
    }
  }
}
