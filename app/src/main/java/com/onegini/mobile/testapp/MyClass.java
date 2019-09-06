package com.onegini.mobile.testapp;

import java.security.SecureRandom;

public class MyClass {

  private static final char[] VALID_CHARACTERS = "0123456879".toCharArray();

  private final SecureRandom secureRandom;

  MyClass(final SecureRandom secureRandom) {
    this.secureRandom = secureRandom;
  }

  public String random(final int length) {
    char[] stringBuffer = new char[length];
    for (int i = 0; i < length; i++) {
      stringBuffer[i] = VALID_CHARACTERS[secureRandom.nextInt(10)];
    }
    return new String(stringBuffer);
  }
}
