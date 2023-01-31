package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public class ClientCode {

    public void constantLogic(int apple) {
        switch (apple) {
            case Constant.APPLE_FUJI -> System.out.println("FUJI");
            case Constant.APPLE_PIPPIN -> System.out.println("PIPPIN");
            case Constant.APPLE_GRANNY_SMITH -> System.out.println("GRANNY_SMITH");
        }
    }

    public void enumLogic(Apple apple) {
        switch (apple) {
            case FUJI -> System.out.println("FUJI");
            case PIPPIN -> System.out.println("PIPPIN");
            case GRANNY_SMITH -> System.out.println("GRANNY_SMITH");
        }
    }
}
