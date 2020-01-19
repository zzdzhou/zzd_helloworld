package jack.helloworld.activiti.controller;

import com.alibaba.fastjson.JSONObject;
import jack.helloworld.activiti.common.ReturnCode;

public class BaseController {

    protected JSONObject success(Object data) {
        return result(ReturnCode.SUCCESS, data);
    }

    protected JSONObject error(ReturnCode code, Exception e) {
        if (e.getMessage() != null) {
            return errorMsgResult(code, e.getMessage());
        }
        return result(code, null);
    }

    private JSONObject result(ReturnCode code, Object data) {
        JSONObject result = new JSONObject();
        result.put("code", code.getCode());
        result.put("message", code.getMessage());
        result.put("data", data);
        return result;
    }

    private JSONObject errorMsgResult(ReturnCode code, String errorMsg) {
        JSONObject result = new JSONObject();
        result.put("code", code.getCode());
        result.put("message", code.getMessage());
        result.put("errorMsg", errorMsg);
        return result;
    }

    public static void main(String[] args) {
        String a = null;
        "".concat(a);
    }

}

