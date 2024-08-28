package com.eugenerara.optimal.encryption.model;

import jakarta.validation.constraints.NotBlank;


public record FilePathRecord(@NotBlank String inputFilePath, @NotBlank String outputFilePath) {
}
