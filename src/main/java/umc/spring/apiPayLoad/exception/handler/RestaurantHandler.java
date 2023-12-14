package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class RestaurantHandler extends GeneralException {

    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}