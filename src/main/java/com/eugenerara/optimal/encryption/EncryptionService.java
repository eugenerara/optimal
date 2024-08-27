package com.eugenerara.optimal.encryption;

public interface EncryptionService {
  void encrypt(String inputFilePath, String outputFilePath);

  void decrypt(String inputFilePath, String outputFilePath);
}
