package com.onegini.mobile.testapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.SecureRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RandomTest {

  private SecureRandom secureRandom;
  private MyClass myClass;

  @Before
  public void setup() throws Exception {
    secureRandom = SecureRandom.getInstance("SHA1PRNG");
    myClass = new MyClass(secureRandom);
  }

  @Test
  public void test() {
    final int random = myClass.random();
    assertThat(random).isLessThan(10);
    assertThat(random).isGreaterThanOrEqualTo(0);
  }

  public class MyClass {

    private final SecureRandom secureRandom;

    MyClass(final SecureRandom secureRandom) {
      this.secureRandom = secureRandom;
    }

    public int random() {
      return secureRandom.nextInt(10);
    }
  }
}
