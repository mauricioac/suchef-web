package utils;

import java.util.UUID;

public class TokenGenerator {
	public static String generate() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
