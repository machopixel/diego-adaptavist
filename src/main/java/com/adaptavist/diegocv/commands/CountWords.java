package com.adaptavist.diegocv.commands;

import com.adaptavist.diegocv.actions.CountService;
import com.adaptavist.diegocv.printer.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class CountWords {

  private final CountService wordCountService;
  private final PrinterService printerService;

  @Autowired
  public CountWords(final CountService wordCountService, final PrinterService printerService) {
    this.wordCountService = wordCountService;
    this.printerService = printerService;
  }

  @ShellMethod(key = "count-words")
  public String countWords(@ShellOption(defaultValue = "test.txt") final String filePath) {
    return printerService.formatMap(wordCountService.countWordsAsMap(filePath));
  }
}
