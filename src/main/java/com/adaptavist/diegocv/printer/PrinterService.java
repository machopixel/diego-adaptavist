package com.adaptavist.diegocv.printer;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {
  public <K, V> String formatMap(Map<K, V> map) {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<K, V> entry : map.entrySet()) {
      result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    }
    return result.toString();
  }
}
