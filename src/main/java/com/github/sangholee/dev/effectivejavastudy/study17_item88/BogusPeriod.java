package com.github.sangholee.dev.effectivejavastudy.study17_item88;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BogusPeriod {

    // Period 인스턴스에서 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
        (byte)0xac, (byte)0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x06
    };

    public static void main(String[] args) {
        Period p = (Period) deserialize(serializedForm);
        System.out.println(p);
    }

    private static Object deserialize(byte[] serializedForm) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedForm)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
