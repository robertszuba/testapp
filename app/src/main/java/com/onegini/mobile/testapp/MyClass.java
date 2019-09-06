package com.onegini.mobile.testapp;

import java.security.SecureRandom;

public class MyClass {

  private final SecureRandom secureRandom;

  MyClass(final SecureRandom secureRandom) {
    this.secureRandom = secureRandom;
  }

  public int random() {
    return secureRandom.nextInt(10);
  }
}
