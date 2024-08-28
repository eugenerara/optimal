package com.eugenerara.optimal.encryption.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class FileEncryptionDto {
    @NotBlank
    String inputFilePath;
    @NotBlank
    String outputFilePath;
}
