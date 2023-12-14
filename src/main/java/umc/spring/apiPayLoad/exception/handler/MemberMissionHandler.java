package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}