//package com.shenxu.zuul.openapi;
//
//import com.hifive.api.ApiException;
//import com.hifive.api.DefaultHifiveClient;
//import com.hifive.api.HifiveClient;
//import com.hifive.api.domain.constants.EducationEnum;
//import com.hifive.api.domain.constants.GenderEnum;
//import com.hifive.api.request.HFBaseLoginRequest;
//import com.hifive.api.response.HFUserGetResponse;
//import com.shenxu.zuul.util.JsonUtils;
//
//public class Test {
//    public static void main(String[] args) {
////        String url = "http://huawei-api-traffic.hifiveai.com";
////        String url = "http://121.36.202.14:8000"; // 正式服
//        String url = "http://121.37.141.72:8000"; // 测试服
////        String url = "https://hifive-openapi-qa.hifiveai.com";
////        String appKey = "6jg58jx4aa9t7305dyck4ckvbyhk7duk"; // 测试
////        String secret = "wnzwnkevnc74uym5"; // 测试
//
//
//        String appKey = "5216d02806d5464b943492838b7e4390"; // 正式
//        String secret = "2d241e8f934d47d5"; // 正式
//
//        HifiveClient client = new DefaultHifiveClient(url, appKey, secret);
//        HFBaseLoginRequest request = new HFBaseLoginRequest();
//        request.setMethod(HFBaseLoginRequest.METHOD_POST);
//        request.setClientId("hf2y7jk19a56qetq05");
//        request.setNickname("zealot");
//        request.setGender(GenderEnum.MAN.ordinal());
//        request.setBirthday(1594639058);
//        request.setLocation("30.779164,103.94547");
//        request.setEducation(EducationEnum.MIDDLE_SCHOOLE.ordinal());
//        request.setProfession(8);
//        request.setFavoriteSinger("周杰伦");
//        request.setFavoriteGenre("1");
//        request.setVersion("V4.0.1");
//
//        HFUserGetResponse response = null;
//        try {
//            response = client.execute(request);
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//        System.out.println(JsonUtils.toJsonString(response));
//    }
//}
