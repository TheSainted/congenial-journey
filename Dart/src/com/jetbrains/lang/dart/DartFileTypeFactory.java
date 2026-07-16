package com.jetbrains.lang.dart;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class DartFileTypeFactory extends FileTypeFactory {
  @Override
  public void createFileTypes(@NotNull final FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(DartFileType.INSTANCE, DartFileType.INSTANCE.getDefaultExtension());
  }
}
