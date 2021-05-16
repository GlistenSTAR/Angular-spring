package com.proyecto.meetup.business_services;

import org.apache.logging.log4j.LogManager;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class Encrypting {
    public static final String SHA1 = "SHA-1";

    public static final String SHA256 = "SHA-256";

    public static final String SHA384 = "SHA-384";

    public static final String SHA512 = "SHA-512";

    private final String algorithm;

    public Encrypting(String algorithm) {
        this.algorithm = algorithm;
    }

    public Encrypting() {
        this(SHA1);
    }

    public byte[] encrypt(String message) {
        byte[] digest = null;
        byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException nsae) {
            LogManager.getLogger(this.getClass()).error("Error: " + nsae);
        }
        return digest;
    }

    public String encryptInBase64() {
        return Base64.getEncoder().encodeToString(this.encrypt(UUID.randomUUID().toString()));
    }

    public String encryptInBase64UrlSafe() {
        String code64Url = Base64.getUrlEncoder().encodeToString(this.encrypt(UUID.randomUUID().toString()));
        return this.removeEqualsCar(code64Url);
    }

    public String shortId64UrlSafe() {
        return this.encryptInBase64UrlSafe().substring(0, 10);
    }

    public String encodeHexInBase64UrlSafe(String hex) {
        return this.removeEqualsCar(Base64.getUrlEncoder().encodeToString(DatatypeConverter.parseHexBinary(hex)));
    }

    public String decodeBase64InHex(String encode) {
        return DatatypeConverter.printHexBinary(Base64.getUrlDecoder().decode(encode)).toLowerCase();
    }

    private String removeEqualsCar(String msg) {
        if (msg.indexOf('=') == -1) {
            return msg;
        } else {
            return msg.substring(0, msg.indexOf('='));
        }
    }
}
