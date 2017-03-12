package com.ek9v.algo.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 18.01.2017.
 */
public class EncryptionTest {

	@Test
	public void testEncrypt() {
		String s = "feedthedog";

		String e = Encryption.encrypt(s);
		System.out.println(e);

		Scanner sc = new Scanner(System.in);
		Assert.assertThat(e, is("fto ehg ee dd"));
	}

}